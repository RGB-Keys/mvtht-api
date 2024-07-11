package mvtht.api.application.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mvtht.api.domain.models.Address;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieTheaterRequest {

    private String name;
    private String email;
    private String phone;
    private String cnpj;
    private Address address;

}
