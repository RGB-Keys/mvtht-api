package mvtht.api.domain.repositories;

import mvtht.api.domain.models.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
}
