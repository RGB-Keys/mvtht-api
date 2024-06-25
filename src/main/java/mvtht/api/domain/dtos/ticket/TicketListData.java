package mvtht.api.domain.dtos.ticket;

import java.math.BigDecimal;

public record TicketListData(
        Long            id,
        TicketType      ticketType,
        BigDecimal      ticketPrice
) {
}
