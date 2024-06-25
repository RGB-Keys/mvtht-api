package mvtht.api.domain.dtos.auditorium;


import mvtht.api.domain.dtos.customer.CustomerType;
import mvtht.api.domain.models.Address;
import mvtht.api.domain.models.MovieTheater;
import mvtht.api.domain.models.Showtime;

public record AuditoriumUpdateData(
        Long            idAuditorium,
        String          number,
        Long            capacity,
        AuditoriumType  auditoriumType,
        MovieTheater    idMovieTheater
) {
}
