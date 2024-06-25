package mvtht.api.domain.dtos.showtime;


import mvtht.api.domain.models.Auditorium;

import java.time.LocalDate;

public record ShowtimeUpdateData(
        Long            id,
        Hour            hour,
        LocalDate showtimeDate,
        String[]        showtimeSeat,
        Auditorium idAuditorium
) {
}
