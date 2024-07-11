package mvtht.api.domain.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mvtht.api.domain.models.Address;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieTheaterRequest {

    private String name;
    private String email;
    private String phone;
    private String cnpj;
    private Address address;

}
