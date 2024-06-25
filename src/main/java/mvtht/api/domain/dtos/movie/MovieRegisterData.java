package mvtht.api.domain.dtos.movie;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import mvtht.api.domain.dtos.address.AddressData;
import mvtht.api.domain.dtos.customer.CustomerType;
import org.hibernate.validator.constraints.br.CPF;

public record MovieRegisterData(
  @NotBlank      String          title,
  @NotBlank      String          gender,
  @NotNull       Classification  classification,
  @NotBlank      String          duration,
  @NotBlank      String          synopsis,
  @NotBlank      String          idiom
) {
}
