package mvtht.api.domain.dtos.movietht;

import mvtht.api.domain.models.Address;

public record MovieThtDetailsData(
        Long            id,
        String          name,
        String          email,
        String          phone,
        String          cnpj,
        Address         address
) {
}
