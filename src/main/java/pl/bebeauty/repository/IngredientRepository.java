package pl.bebeauty.repository;

import org.springframework.data.repository.CrudRepository;
import pl.bebeauty.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
