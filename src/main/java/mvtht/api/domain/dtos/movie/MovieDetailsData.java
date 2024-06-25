package mvtht.api.domain.dtos.movie;

public record MovieDetailsData(
        Long            id,
        String          title,
        String          gender,
        Classification  classification,
        String          duration,
        String          synopsis,
        String          idiom
) {
}
