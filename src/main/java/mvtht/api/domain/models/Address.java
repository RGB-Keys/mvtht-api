package mvtht.api.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mvtht.api.domain.dtos.address.AddressData;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Embeddable
public class Address {

    @Column(name = "zip_code")
    private String zipcode;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "neighborhood")
    private String neighborhood;

    @Column(name = "number")
    private String number;

    public Address(AddressData data) {
        this(data.zipcode(), data.country(), data.state(), data.city(), data.street(), data.neighborhood(), data.number());
    }
}
