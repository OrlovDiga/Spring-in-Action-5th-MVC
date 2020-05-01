package sia.tacocloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import sia.tacocloud.domain.Ingredient;
import sia.tacocloud.domain.User;
import sia.tacocloud.repo.IngredientRepo;
import sia.tacocloud.domain.Ingredient.Type;
import sia.tacocloud.repo.UserRepo;


/**
 * @author Orlov Diga
 */
@Slf4j
@Profile("!prod")
@Configuration
public class DevelopmentConfig {

    @Bean
    @Profile("!prod")
    CommandLineRunner dataLoader(IngredientRepo ingredientRepo, UserRepo userRepo, PasswordEncoder encoder) {
        return args -> {
            log.info("Start initialization ingredients...");

            ingredientRepo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
            ingredientRepo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
            ingredientRepo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
            ingredientRepo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
            ingredientRepo.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
            ingredientRepo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
            ingredientRepo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
            ingredientRepo.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
            ingredientRepo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
            ingredientRepo.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));

            log.info("Check load db {}", ingredientRepo.findAll());

            userRepo.save(new User("habuma", encoder.encode("password"),
                    "Craig Walls", "123 North Street", "Cross Roads", "TX",
                    "76227", "123-123-1234"));
        };
    }
}
