package mvtht.api.domain.services;

import mvtht.api.application.dtos.request.MovieRequest;
import mvtht.api.application.dtos.response.MovieResponse;
import mvtht.api.application.dtos.update.MovieUpdate;
import mvtht.api.application.mapper.generic.Mapper;
import mvtht.api.application.services.GenericService;
import mvtht.api.domain.models.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService extends GenericService<Movie, Long, MovieRequest, MovieUpdate, MovieResponse> {

    public MovieService(JpaRepository<Movie, Long> repository,
                        Mapper<Movie, MovieRequest, MovieUpdate, MovieResponse> mapper) {
        super(repository, mapper);

    }
}