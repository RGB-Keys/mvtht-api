package mvtht.api.domain.dtos.order;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import mvtht.api.domain.dtos.address.AddressData;
import mvtht.api.domain.models.Customer;
import mvtht.api.domain.models.Ticket;
import org.hibernate.validator.constraints.br.CNPJ;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderRegisterData(
   @NotNull     Long            id,
   @NotNull     OrderStatus     orderStatus,
   @NotNull     LocalDateTime   orderDate,
   @NotNull     Customer        idCustomer,
   @NotNull     Ticket          idTicket,
   @NotNull     Integer         ticketAmount,
   @NotNull     BigDecimal      priceTotal
) {
}
