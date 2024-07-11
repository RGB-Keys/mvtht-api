package mvtht.api.application.mapper.specific;

import mvtht.api.application.dtos.request.MovieRequest;
import mvtht.api.application.dtos.response.MovieResponse;
import mvtht.api.application.dtos.update.MovieUpdate;
import mvtht.api.domain.models.Movie;
import mvtht.api.application.mapper.generic.GenericMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper extends GenericMapper<Movie, MovieRequest, MovieUpdate, MovieResponse> {

    @Autowired
    public MovieMapper(ModelMapper mapper) {
        super(Movie.class, MovieResponse.class, mapper);
    }

}