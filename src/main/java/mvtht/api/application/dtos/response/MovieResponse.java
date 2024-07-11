package mvtht.api.application.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mvtht.api.application.enums.Classification;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieResponse {

    private Long id;
    private String title;
    private String gender;
    private Classification classification;
    private String duration;
    private String synopsis;
    private String idiom;

}
