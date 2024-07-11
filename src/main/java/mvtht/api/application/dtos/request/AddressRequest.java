package mvtht.api.application.dtos.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressRequest {

    private String zip_code;
    private String country;
    private String state;
    private String city;
    private String street;
    private String neighborhood;
    private String number;

}
