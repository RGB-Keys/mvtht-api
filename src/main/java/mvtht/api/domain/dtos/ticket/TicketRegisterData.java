package mvtht.api.domain.dtos.ticket;

import jakarta.validation.constraints.NotNull;
import mvtht.api.domain.dtos.showtime.Hour;
import mvtht.api.domain.models.Auditorium;
import mvtht.api.domain.models.Order;
import mvtht.api.domain.models.Showtime;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TicketRegisterData(
   @NotNull     Long            id,
   @NotNull     TicketType      ticketType,
   @NotNull     BigDecimal      ticketPrice,
   @NotNull     Order           idOrder,
   @NotNull     Showtime        idShowtime
) {
}
