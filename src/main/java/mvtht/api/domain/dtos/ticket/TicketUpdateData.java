package mvtht.api.domain.dtos.ticket;

import mvtht.api.domain.models.Order;
import mvtht.api.domain.models.Showtime;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TicketUpdateData(
        Long            id,
        TicketType      ticketType,
        BigDecimal      ticketPrice,
        Order           idOrder,
        Showtime        idShowtime
) {
}
