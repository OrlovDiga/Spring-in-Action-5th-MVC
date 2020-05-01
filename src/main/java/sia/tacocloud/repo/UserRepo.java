package sia.tacocloud.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sia.tacocloud.domain.User;

/**
 * @author Orlov Diga
 */
@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
