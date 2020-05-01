package sia.tacocloud.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sia.tacocloud.domain.Ingredient;

import java.util.List;

/**
 * @author Orlov Diga
 */
@Repository
public interface IngredientRepo extends CrudRepository<Ingredient, String> {

    List<Ingredient> findAll();
}
