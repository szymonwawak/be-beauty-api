package pl.bebeauty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.bebeauty.model.Category;
import pl.bebeauty.model.Product;
import pl.bebeauty.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repository;

    @Autowired
    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    Iterable<Product> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Product> findById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    Product create(@RequestBody Product product) {
        return repository.save(product);
    }

    @PutMapping
    Product update(@RequestBody Product product) {
        return repository.save(product);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PostMapping("/findByBarcode")
    Product getByBarcode(@RequestBody String barcode) {
        return repository.findByBarcode(barcode);
    }

    @PostMapping("/search")
    List<Product> filterProducts(@RequestPart(required = false) String name, @RequestPart Category category, int pageNumber, int pageSize) {
        name = name == null ? "" : name;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Product> products = repository.findByNameContainingAndCategoryOrderByAverageScore(name, category, pageable);
        return products.getContent();
    }

}