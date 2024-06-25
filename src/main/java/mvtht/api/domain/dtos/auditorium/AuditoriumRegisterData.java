package mvtht.api.domain.dtos.auditorium;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import mvtht.api.domain.dtos.address.AddressData;
import mvtht.api.domain.dtos.customer.CustomerType;
import mvtht.api.domain.models.MovieTheater;
import org.hibernate.validator.constraints.br.CPF;

public record AuditoriumRegisterData(
        @NotBlank               String          number,
        @NotNull                Long            capacity,
        @NotNull                AuditoriumType  auditoriumType,
        @NotNull                MovieTheater    idMovieTheater
) {
}
