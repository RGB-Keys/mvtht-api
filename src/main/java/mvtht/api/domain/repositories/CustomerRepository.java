package mvtht.api.domain.repositories;

import mvtht.api.domain.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
