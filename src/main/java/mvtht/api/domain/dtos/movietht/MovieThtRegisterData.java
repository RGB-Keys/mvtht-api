package mvtht.api.domain.dtos.movietht;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import mvtht.api.domain.dtos.address.AddressData;
import org.hibernate.validator.constraints.br.CNPJ;

public record MovieThtRegisterData(
        @NotBlank               String          name,
        @NotBlank               String          email,
        @NotBlank               String          phone,
        @NotNull     @CNPJ      String          cnpj,
        @NotNull     @Valid     AddressData     address
        ) {
}
