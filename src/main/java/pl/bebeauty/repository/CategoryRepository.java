package pl.bebeauty.repository;

import org.springframework.data.repository.CrudRepository;
import pl.bebeauty.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
