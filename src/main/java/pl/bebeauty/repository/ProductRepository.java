package pl.bebeauty.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.bebeauty.model.Category;
import pl.bebeauty.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByBarcode(String barcode);

    Page<Product> findByNameContainingAndCategoryOrderByAverageScore(String name, Category category, Pageable pageable);
}
