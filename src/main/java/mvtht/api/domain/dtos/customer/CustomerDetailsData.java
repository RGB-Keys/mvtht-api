package mvtht.api.domain.dtos.customer;

import mvtht.api.domain.models.Address;

public record CustomerDetailsData(
        Long            id,
        String          name,
        String          email,
        String          phone,
        String          cpf,
        CustomerType    customerType,
        Address         address
) {
}
