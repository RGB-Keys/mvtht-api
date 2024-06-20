package mvtht.api.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mvtht.api.domain.dtos.movietht.MovieThtRegisterData;
import mvtht.api.domain.dtos.movietht.MovieThtUpdateData;

@Entity
@Table(name = "movie_theaters")
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MovieTheater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movie_theater")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "cnpj")
    private String cnpj;

    @Embedded
    @Column(name = "address")
    private Address address;

    public MovieTheater (MovieThtRegisterData data) {
        this(null ,data.name(), data.email(), data.phone(), data.cnpj(), new Address(data.address()));
    }

    public void UpdateMovieTheater(MovieThtUpdateData data){
        if (this.name != null) this.name = data.name();

        if (this.email != null)  this.email = data.email();

        if (this.phone != null)  this.phone = data.phone();

        if(this.address != null)  this.address = data.address();
    }
}
