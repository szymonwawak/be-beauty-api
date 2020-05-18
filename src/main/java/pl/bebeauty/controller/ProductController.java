package pl.bebeauty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.bebeauty.model.Product;
import pl.bebeauty.repository.ProductRepository;

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
}