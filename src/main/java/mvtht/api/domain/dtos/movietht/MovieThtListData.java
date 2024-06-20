package mvtht.api.domain.dtos.movietht;

import mvtht.api.domain.models.Address;

public record MovieThtListData(
        String name,
        String email,
        String phone,
        Address address
) {
}
