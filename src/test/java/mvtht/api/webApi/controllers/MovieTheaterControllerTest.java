package mvtht.api.webApi.controllers;

import mvtht.api.application.dtos.request.MovieTheaterRequest;
import mvtht.api.application.dtos.response.MovieTheaterResponse;
import mvtht.api.application.dtos.update.MovieTheaterUpdate;
import mvtht.api.domain.models.Address;
import mvtht.api.domain.services.MovieTheaterService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@AutoConfigureJsonTesters
@AutoConfigureMockMvc
@SpringBootTest
public class MovieTheaterControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<MovieTheaterRequest> requestJson;

    @Autowired
    private JacksonTester<MovieTheaterResponse> responseJson;

    @MockBean
    private MovieTheaterService service;


    @Test
    @DisplayName("Código 400 - Nada declarado")
    void request_invalid() throws Exception {
        var response = mvc
                .perform(post("/movietht"))
                .andReturn().getResponse();

        assertThat(response.getStatus())
                .isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Código 201 - Dados conferem")
    void request_valid() throws Exception {

        var movietht_request = moviethtRequest1();
        var movietht_response = moviethtResponse1();

        when(service.save(any(MovieTheaterRequest.class))).thenReturn(movietht_response);

        var response = mvc
                .perform(post("/movietht")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson.write(movietht_request).getJson()))
                .andReturn().getResponse();

        var json = responseJson.write(movietht_response).getJson();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isEqualTo(json);
    }


    private MovieTheaterRequest moviethtRequest1() {
        return new MovieTheaterRequest(
                "Cinema 01",
                "Cinema01@gmail.com",
                "819999999999",
                "1599874563",
                new Address(
                        "78945615612",
                        "Brasil",
                        "Sergipe",
                        "Uma la",
                        "Qualquer uma",
                        "Sei la",
                        "100A"
                )
        );
    }

    private MovieTheaterRequest moviethtRequest2() {
        return new MovieTheaterRequest(
                "Cinema 02",
                "Cinema02@gmail.com",
                "819999988999",
                "1599874343",
                new Address(
                        "78945615612",
                        "Brasil",
                        "Sergipe",
                        "Uma la",
                        "Qualquer uma",
                        "Sei la",
                        "104A"
                )
        );
    }

    private MovieTheaterResponse moviethtResponse1() {
        return new MovieTheaterResponse(
                null,
                moviethtRequest1().getName(),
                moviethtRequest1().getEmail(),
                moviethtRequest1().getPhone(),
                moviethtRequest1().getCnpj(),
                moviethtRequest1().getAddress()
        );
    }

    private MovieTheaterUpdate movieUpdate1() {
        return new MovieTheaterUpdate(
                "Cinema01@gmail.com",
                "819999459999",
                new Address(
                        "78945615612",
                        "Brasil",
                        "Alagoas",
                        "Uma la",
                        "Qualquer uma",
                        "Sei la",
                        "100A"
                )
        );
    }
}
