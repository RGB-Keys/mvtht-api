package mvtht.api.domain.dtos.movietht;


import mvtht.api.domain.dtos.customer.CustomerType;
import mvtht.api.domain.models.Address;

public record MovieThtUpdateData(
        Long idMovieTheather,
        String name,
        String email,
        String phone,
        Address address
) {
}
