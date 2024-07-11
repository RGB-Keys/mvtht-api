package mvtht.api.domain.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mvtht.api.domain.models.Address;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieTheaterResponse {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String cnpj;
    private Address address;

}