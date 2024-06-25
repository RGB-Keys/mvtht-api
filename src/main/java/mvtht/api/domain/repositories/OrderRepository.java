package mvtht.api.domain.repositories;

import mvtht.api.domain.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
