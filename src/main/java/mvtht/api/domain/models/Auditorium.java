package mvtht.api.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mvtht.api.domain.dtos.auditorium.AuditoriumRegisterData;
import mvtht.api.domain.dtos.auditorium.AuditoriumType;
import mvtht.api.domain.dtos.auditorium.AuditoriumUpdateData;

@Entity
@Table(name = "auditoriums")
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Auditorium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_auditorium")
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "capacity")
    private Long capacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "auditorium_type")
    private AuditoriumType auditoriumType;

    @ManyToOne
    @JoinColumn(name = "id_movie_theater")
    private MovieTheater idMovieTheater;


    public Auditorium(AuditoriumRegisterData data) {
        this(null, data.number(), data.capacity(), data.auditoriumType(), data.idMovieTheater());
    }

    public void UpdateAuditorium (AuditoriumUpdateData data) {
        if (this.number != null) this.number = data.number();

        if (this.capacity != null) this.capacity = data.capacity();

        if (this.auditoriumType != null) this.auditoriumType = data.auditoriumType();

        if (this.idMovieTheater != null) this.idMovieTheater = data.idMovieTheater();
    }
}
