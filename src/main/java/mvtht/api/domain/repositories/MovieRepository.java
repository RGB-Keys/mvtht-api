package mvtht.api.domain.repositories;

import mvtht.api.domain.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
