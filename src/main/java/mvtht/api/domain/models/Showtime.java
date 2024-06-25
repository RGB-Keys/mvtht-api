package mvtht.api.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mvtht.api.domain.dtos.showtime.Hour;

import java.time.LocalDate;

@Entity
@Table(name = "showtimes")
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_showtime")
    private Long id;

    @Column(name = "hour_showtime")
    private Hour hour;

    @Column(name = "showtime_date")
    private LocalDate showtimeDate = LocalDate.now();

    @Column(name = "showtime_seat")
    private String[] showtimeSeat;

    @ManyToOne
    @JoinColumn(name = "id_auditorium")
    private Auditorium idAuditorium;

}
