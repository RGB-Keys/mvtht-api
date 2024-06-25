package mvtht.api.domain.dtos.movietht;

import mvtht.api.domain.models.Address;

public record MovieThtUpdateData(
        Long idMovieTheater,
        String name,
        String email,
        String phone,
        Address address
) {
}
