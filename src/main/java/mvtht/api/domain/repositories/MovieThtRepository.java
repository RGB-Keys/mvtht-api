package mvtht.api.domain.repositories;

import mvtht.api.domain.models.MovieTheater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieThtRepository extends JpaRepository<MovieTheater, Long> {
}
