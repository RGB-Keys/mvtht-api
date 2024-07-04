package mvtht.api.domain.mapper;

import lombok.RequiredArgsConstructor;
import mvtht.api.domain.dtos.request.MovieRequest;
import mvtht.api.domain.dtos.response.MovieResponse;
import mvtht.api.domain.dtos.update.MovieUpdate;
import mvtht.api.domain.models.Movie;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MovieMapper {

    @Autowired
    private ModelMapper mapper;

    public Movie toMovie(MovieRequest request) { return mapper.map(request, Movie.class); }

    public MovieResponse toMovieResponse(Movie movie) { return mapper.map(movie, MovieResponse.class); }

    public Movie toUpdateMovie(MovieUpdate request, Movie movie) {
        mapper.map(request, movie);
        return movie; }

    public List<MovieResponse> toMovieResponseList(List<Movie> movies) {
        return movies.stream()
                .map(this::toMovieResponse)
                .collect(Collectors.toList());
    }
}