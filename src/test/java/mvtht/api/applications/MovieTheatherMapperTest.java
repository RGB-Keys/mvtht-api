package mvtht.api.applications;

import mvtht.api.application.dtos.request.MovieTheaterRequest;
import mvtht.api.application.dtos.response.MovieTheaterResponse;
import mvtht.api.application.dtos.update.MovieTheaterUpdate;
import mvtht.api.application.mapper.specific.MovieTheaterMapper;
import mvtht.api.domain.models.Address;
import mvtht.api.domain.models.MovieTheater;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class MovieTheatherMapperTest {

    private MovieTheaterMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new MovieTheaterMapper(new ModelMapper());
    }

    @Test
    void testToEntity() {
        MovieTheater entity = mapper.toEntity(moviethtRequest1());
        assertEquals("Cinema 01", entity.getName());
        assertEquals("1599874563", entity.getCnpj());
    }

    @Test
    void testUpdate() {
        MovieTheater entity = mapper.toEntity(moviethtRequest1());
        mapper.update(moviethtUpdate1(), entity);
        assertEquals("Alagoas", entity.getAddress().getState());
        assertEquals("Cinema 01", entity.getName());
    }

    @Test
    void testToResponse() {
        MovieTheater entity = mapper.toEntity(moviethtRequest1());
        MovieTheaterResponse response = mapper.toResponse(entity);
        assertEquals(entity.getName(), response.getName());
        assertEquals(entity.getCnpj(), response.getCnpj());
    }

    @Test
    void testToResponseList() {
        MovieTheater entity1 = mapper.toEntity(moviethtRequest1());
        MovieTheater entity2 = mapper.toEntity(moviethtRequest2());

        List<MovieTheater> entities = List.of(entity1, entity2);
        List<MovieTheaterResponse> responses = mapper.toResponseList(entities);
        Assertions.assertEquals(2, responses.size());
        Assertions.assertEquals("Cinema 01", responses.get(0).getName());
        Assertions.assertEquals("Cinema 02", responses.get(1).getName());
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

    private MovieTheaterUpdate moviethtUpdate1() {
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