package sia.tacocloud.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sia.tacocloud.domain.Taco;

/**
 * @author Orlov Diga
 */
@Repository
public interface TacoRepo extends CrudRepository<Taco, Long> {
}
