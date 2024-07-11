package mvtht.api.application.mapper;

import mvtht.api.application.dtos.request.MovieRequest;
import mvtht.api.application.dtos.response.MovieResponse;
import mvtht.api.application.dtos.update.MovieUpdate;
import mvtht.api.domain.models.Movie;
import mvtht.api.infra.mapper.GenericMapper;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper extends GenericMapper<Movie, MovieRequest, MovieUpdate, MovieResponse> {
    public MovieMapper() {
        super(Movie.class, MovieResponse.class);
    }
}
