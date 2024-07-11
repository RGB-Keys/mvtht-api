package mvtht.api.webApi.controllers;

import mvtht.api.application.dtos.request.MovieRequest;
import mvtht.api.application.dtos.response.MovieResponse;
import mvtht.api.application.dtos.update.MovieUpdate;
import mvtht.api.application.enums.Classification;
import mvtht.api.domain.models.Movie;
import mvtht.api.domain.services.MovieService;
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

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@AutoConfigureJsonTesters
@AutoConfigureMockMvc
@SpringBootTest
public class MovieControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<MovieRequest> requestJson;

    @Autowired
    private JacksonTester<MovieResponse> responseJson;

    @MockBean
    private MovieService service;

    @Test
    @DisplayName("Código 400 - Nada declarado")
    void request_invalid() throws Exception {
        var response = mvc
                .perform(post("/movie"))
                .andReturn().getResponse();

        assertThat(response.getStatus())
                .isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Código 201 - Dados conferem")
    void request_valid() throws Exception {

        var movie_request = request1();
        var movie_response = response1();

        when(service.save(any(MovieRequest.class))).thenReturn(response1());

        var response = mvc
                .perform(post("/movie")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson.write(movie_request).getJson()))
                .andReturn().getResponse();

        var json = responseJson.write(movie_response).getJson();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isEqualTo(json);

    }

    private MovieRequest request1() {
        return new MovieRequest(
                "Inception",
                "Sci-Fi",
                Classification.m_16,
                "1H40m",
                "Tentativa 1",
                "Ingles"
        );
    }

    private MovieRequest request2() {
        return new MovieRequest(
                "Interstellar",
                "Sci-Fi",
                Classification.m_14,
                "1H40m",
                "Tentativa 2",
                "Ingles"
        );
    }

    private MovieResponse response1() {
        return new MovieResponse(
                null,
                request1().getTitle(),
                request1().getGender(),
                request1().getClassification(),
                request1().getDuration(),
                request1().getSynopsis(),
                request1().getIdiom()
        );
    }

    private MovieUpdate update() {
        return new MovieUpdate(
                "Alien",
                "Sci-Fi",
                Classification.m_16,
                "2H10m",
                "Tentativa de Atualização",
                "Ingles"
        );
    }
}
