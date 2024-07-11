package mvtht.api.applications;

import mvtht.api.application.dtos.request.MovieRequest;
import mvtht.api.application.dtos.response.MovieResponse;
import mvtht.api.application.dtos.update.MovieUpdate;
import mvtht.api.application.enums.Classification;
import mvtht.api.application.mapper.specific.MovieMapper;
import mvtht.api.domain.models.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieMapperTest {

    private MovieMapper movieMapper;

    @BeforeEach
    void setUp() {
        movieMapper = new MovieMapper(new ModelMapper());
    }

    @Test
    void testToEntity() {
        Movie entity = movieMapper.toEntity(request1());
        assertEquals("Inception", entity.getTitle());
        assertEquals("Sci-Fi", entity.getGender());
    }

    @Test
    void testUpdateEntityFromDto() {
        Movie entity = movieMapper.toEntity(request1());
        movieMapper.update(update(), entity);
        assertEquals("Alien", entity.getTitle());
        assertEquals("Sci-Fi", entity.getGender());
    }

    @Test
    void testToResponse() {
        Movie entity = movieMapper.toEntity(request1());
        MovieResponse response = movieMapper.toResponse(entity);
        assertEquals("Inception", response.getTitle());
        assertEquals("Sci-Fi", response.getGender());
    }

    @Test
    void testToResponseList() {
        Movie entity1 = movieMapper.toEntity(request1());
        Movie entity2 = movieMapper.toEntity(request2());

        List<Movie> entities = List.of(entity1, entity2);
        List<MovieResponse> responses = movieMapper.toResponseList(entities);
        assertEquals(2, responses.size());
        assertEquals("Inception", responses.get(0).getTitle());
        assertEquals("Interstellar", responses.get(1).getTitle());
    }

    private MovieRequest request1() {
        return new MovieRequest(
                "Inception",
                "Sci-Fi",
                Classification.m_16,
                "1H40m",
                "Tentativa 1",
                "Inglês"
        );
    }

    private MovieRequest request2() {
        return new MovieRequest(
                "Interstellar",
                "Sci-Fi",
                Classification.m_14,
                "1H40m",
                "Tentativa 2",
                "Inglês"
        );
    }

    private MovieUpdate update() {
        return new MovieUpdate(
                "Alien",
                "Sci-Fi",
                Classification.m_16,
                "2H10m",
                "Tentativa de Atualização",
                "Inglês"
        );
    }

}
