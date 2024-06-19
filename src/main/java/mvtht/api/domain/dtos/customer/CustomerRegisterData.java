package mvtht.api.domain.dtos.customer;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import mvtht.api.domain.dtos.address.AddressData;
import org.hibernate.validator.constraints.br.CPF;

public record CustomerRegisterData(
        @NotBlank               String          name,
        @NotBlank               String          email,
        @NotBlank               String          phone,
        @NotNull     @CPF       String          cpf,
        @NotNull                CustomerType    customerType,
        @NotNull     @Valid     AddressData     address
        ) {
}
