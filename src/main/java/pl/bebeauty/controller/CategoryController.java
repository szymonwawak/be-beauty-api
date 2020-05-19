package pl.bebeauty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.bebeauty.model.Category;
import pl.bebeauty.repository.CategoryRepository;

import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryRepository repository;

    @Autowired
    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    Iterable<Category> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Category> findById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    Category create(@RequestBody Category category) {
        return repository.save(category);
    }

    @PutMapping
    Category update(@RequestBody Category category) {
        return repository.save(category);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
