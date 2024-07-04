package mvtht.api.domain.models;

import jakarta.persistence.*;
import lombok.*;
import mvtht.api.domain.dtos.movie.Classification;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movie")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "gender")
    private String gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "classification")
    private Classification classification;

    @Column(name = "duration")
    private String duration;

    @Column(name = "synopsis")
    private String synopsis;

    @Column(name = "idiom")
    private String idiom;
}
