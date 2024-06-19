package mvtht.api.domain.dtos.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressData(
        @NotBlank @Pattern(regexp = "\\d{8}") String zipcode,
        @NotBlank String country,
        @NotBlank String state,
        @NotBlank String city,
        @NotBlank String street,
        @NotBlank String neighborhood,
        String number
) {
}
