package mvtht.api.application.dtos.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mvtht.api.domain.models.Address;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieTheaterUpdate {

    private String email;
    private String phone;
    private Address address;

}
