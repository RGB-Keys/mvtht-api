package mvtht.api.domain.repositories;

import mvtht.api.domain.models.MovieTheater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieTheatherRepository extends JpaRepository<MovieTheater, Long> {
}
