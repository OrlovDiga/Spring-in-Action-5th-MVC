package sia.tacocloud.repo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sia.tacocloud.domain.Order;
import sia.tacocloud.domain.User;

import java.util.List;

/**
 * @author Orlov Diga
 */
@Repository
public interface OrderRepo extends CrudRepository<Order, Long> {

    List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}
