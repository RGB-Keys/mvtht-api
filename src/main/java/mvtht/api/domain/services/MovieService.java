package mvtht.api.domain.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mvtht.api.domain.dtos.request.MovieRequest;
import mvtht.api.domain.dtos.response.MovieResponse;
import mvtht.api.domain.dtos.update.MovieUpdate;
import mvtht.api.domain.mapper.MovieMapper;
import mvtht.api.domain.models.Movie;
import mvtht.api.domain.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieMapper mapper;

    public MovieResponse save(MovieRequest request) {
        Movie movie = mapper.toMovie(request);
        Movie savedMovie = movieRepository.save(movie);
        return mapper.toMovieResponse(savedMovie);
    }

    public List<MovieResponse> list() {
        List<Movie> movies = movieRepository.findAll();
        return mapper.toMovieResponseList(movies);
    }

    public MovieResponse findById(Long id) {
        Optional<Movie> optMovie = movieRepository.findById(id);

        if(optMovie.isEmpty()) {
            throw new RuntimeException("Movie not found...");
        }

        Movie existingMovie = optMovie.get();
        return mapper.toMovieResponse(existingMovie);
    }

    public MovieResponse update(Long id, MovieUpdate request){
        Optional<Movie> optMovie = movieRepository.findById(id);

        if(optMovie.isEmpty()) {
            throw new RuntimeException("Movie not found...");
        }

        Movie existingMovie = optMovie.get();
        mapper.toUpdateMovie(request, existingMovie);

        Movie updatedMovie = movieRepository.save(existingMovie);
        return mapper.toMovieResponse(existingMovie);
    }

    public void delete(Long id) {
        Optional<Movie> optMovie = movieRepository.findById(id);

        if(optMovie.isEmpty()) {
            throw new RuntimeException("Movie not found...");
        }

//        Movie existingMovie = optMovie.get(); --> Caso queira implementar Lógica...
        movieRepository.deleteById(id);
    }

}