package mvtht.api.domain.services;

import mvtht.api.application.dtos.request.MovieTheaterRequest;
import mvtht.api.application.dtos.response.MovieTheaterResponse;
import mvtht.api.application.dtos.update.MovieTheaterUpdate;
import mvtht.api.application.services.GenericService;
import mvtht.api.domain.models.MovieTheater;
import mvtht.api.application.mapper.generic.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieTheaterService extends GenericService<MovieTheater, Long, MovieTheaterRequest,
        MovieTheaterUpdate, MovieTheaterResponse> {

    public MovieTheaterService(JpaRepository<MovieTheater, Long> repository,
                               Mapper<MovieTheater, MovieTheaterRequest,
                                       MovieTheaterUpdate, MovieTheaterResponse> mapper) {
        super(repository, mapper);

    }
}
