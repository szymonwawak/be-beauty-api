package pl.bebeauty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.bebeauty.model.Category;
import pl.bebeauty.model.Ingredient;
import pl.bebeauty.model.Product;
import pl.bebeauty.repository.IngredientRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    private final IngredientRepository repository;

    @Autowired
    public IngredientController(IngredientRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    Iterable<Ingredient> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Ingredient> findById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    Ingredient create(@RequestBody Ingredient ingredient) {
        return repository.save(ingredient);
    }

    @PutMapping
    Ingredient update(@RequestBody Ingredient ingredient) {
        return repository.save(ingredient);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PostMapping("/search")
    List<Ingredient> findByName(@RequestPart(required = false) String name, int pageNumber, int pageSize) {
        name = name == null ? "" : name;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Ingredient> ingredients = repository.findByNameContainingOrderByName(name, pageable);
        return ingredients.getContent();
    }
}
