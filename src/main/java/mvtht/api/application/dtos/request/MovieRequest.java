package mvtht.api.domain.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mvtht.api.domain.dtos.movie.Classification;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieRequest {

    private String title;
    private String gender;
    private Classification classification;
    private String duration;
    private String synopsis;
    private String idiom;

}
