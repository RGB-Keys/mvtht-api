package mvtht.api.domain.dtos.movie;


import mvtht.api.domain.dtos.customer.CustomerType;
import mvtht.api.domain.models.Address;

public record MovieUpdateData(
        Long            id,
        String          title,
        String          gender,
        Classification  classification,
        String          duration,
        String          synopsis,
        String          idiom
) {
}
