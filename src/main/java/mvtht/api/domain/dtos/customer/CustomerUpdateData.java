package mvtht.api.domain.dtos.customer;


import mvtht.api.domain.models.Address;

public record CustomerUpdateData(
        Long idCustomer,
        String name,
        String email,
        String phone,
        CustomerType customerType,
        Address address
) {
}
