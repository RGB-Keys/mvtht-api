package mvtht.api.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mvtht.api.domain.dtos.address.AddressData;
import mvtht.api.domain.dtos.customer.CustomerRegisterData;
import mvtht.api.domain.dtos.customer.CustomerType;
import mvtht.api.domain.dtos.customer.CustomerUpdateData;

@Entity
@Table(name = "customers")
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "cpf")
    private String cpf;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_type")
    private CustomerType customerType;

    @Embedded
    @Column(name = "address")
    private Address address;

    public Customer(CustomerRegisterData data) {
        this(null ,data.name(), data.email(), data.phone(), data.cpf(), data.customerType(), new Address(data.address()));
    }

    public void UpdateCustomer (CustomerUpdateData data){
        if (this.name != null) this.name = data.name();

        if (this.email != null)  this.email = data.email();

        if (this.phone != null)  this.phone = data.phone();

        if (this.customerType != null)  this.customerType = data.customerType();

        if(this.address != null)  this.address = data.address();
    }
}
