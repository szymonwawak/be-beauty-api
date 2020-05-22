package pl.bebeauty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bebeauty.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
