package mvtht.api.domain.dtos.auditorium;

import mvtht.api.domain.models.MovieTheater;

public record AuditoriumDetailsData(
        Long                id,
        String              number,
        Long                capacity,
        AuditoriumType      auditoriumType,
        MovieTheater        idMovieTheater
) {
}
