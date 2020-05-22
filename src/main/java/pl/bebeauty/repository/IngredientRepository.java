package pl.bebeauty.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.bebeauty.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Page<Ingredient> findByNameContainingOrderByName(String name, Pageable pageable);
}
