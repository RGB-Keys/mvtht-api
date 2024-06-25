package mvtht.api.domain.dtos.order;

import mvtht.api.domain.models.Customer;
import mvtht.api.domain.models.Ticket;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderDetailsData(
        Long            id,
        OrderStatus     orderStatus,
        LocalDateTime   orderDate,
        Customer        idCustomer,
        Ticket          idTicket,
        Integer         ticketAmount,
        BigDecimal      priceTotal
) {
}
