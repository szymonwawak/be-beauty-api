package pl.bebeauty.repository;

import org.springframework.data.repository.CrudRepository;
import pl.bebeauty.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
