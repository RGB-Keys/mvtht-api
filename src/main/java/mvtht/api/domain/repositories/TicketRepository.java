package mvtht.api.domain.repositories;

import mvtht.api.domain.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
