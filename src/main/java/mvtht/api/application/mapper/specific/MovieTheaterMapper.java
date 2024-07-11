package mvtht.api.application.mapper;

//import lombok.RequiredArgsConstructor;
//import mvtht.api.application.dtos.request.MovieTheaterRequest;
//import mvtht.api.application.dtos.response.MovieTheaterResponse;
//import mvtht.api.application.dtos.update.MovieTheaterUpdate;
//import mvtht.api.domain.models.MovieTheater;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
import mvtht.api.application.dtos.request.MovieTheaterRequest;
import mvtht.api.application.dtos.response.MovieTheaterResponse;
import mvtht.api.application.dtos.update.MovieTheaterUpdate;
import mvtht.api.domain.models.MovieTheater;
import mvtht.api.infra.mapper.GenericMapper;
import org.springframework.stereotype.Component;
//import java.util.List;
//import java.util.stream.Collectors;

//@RequiredArgsConstructor
@Component
public class MovieTheaterMapper extends GenericMapper<MovieTheater, MovieTheaterRequest,
        MovieTheaterUpdate, MovieTheaterResponse> {
    public MovieTheaterMapper() {
        super(MovieTheater.class, MovieTheaterResponse.class);
    }

//  Anteriormente estava assim:
//
//    @Autowired
//    private ModelMapper mapper;
//
//    public MovieTheater toMovieTheater(MovieTheaterRequest request) {
//        return mapper.map(request, MovieTheater.class);
//    }
//
//    public MovieTheaterResponse toMovieTheaterResponse(MovieTheater movieTheater) {
//        return mapper.map(movieTheater, MovieTheaterResponse.class);
//    }
//
//    public MovieTheater toMovieTheaterUpdate(MovieTheaterUpdate update, MovieTheater movieTheater) {
//        mapper.map(update, movieTheater);
//        return movieTheater;
//    }
//
//    public List<MovieTheaterResponse> toMovieTheaterResponseList(List<MovieTheater> movieTheaters) {
//        return movieTheaters.stream()
//                .map(this::toMovieTheaterResponse)
//                .collect(Collectors.toList());
//    }
}
