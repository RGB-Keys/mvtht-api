package mvtht.api.domain.dtos.order;

import mvtht.api.domain.models.Ticket;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderUpdateData(
        Long            id,
        OrderStatus     orderStatus,
        LocalDateTime   orderDate,
        Ticket          idTicket,
        Integer         ticketAmount,
        BigDecimal      priceTotal
) {
}
