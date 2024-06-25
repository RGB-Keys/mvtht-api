package mvtht.api.domain.dtos.showtime;

import jakarta.validation.constraints.NotNull;
import mvtht.api.domain.models.Auditorium;

import java.time.LocalDate;

public record ShowtimeRegisterData(
   @NotNull     Long            id,
   @NotNull     Hour            hour,
   @NotNull     LocalDate       showtimeDate,
   @NotNull     String[]        showtimeSeat,
   @NotNull     Auditorium      idAuditorium
) {
}
