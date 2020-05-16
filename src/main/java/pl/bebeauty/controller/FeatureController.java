package pl.bebeauty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.bebeauty.model.Feature;
import pl.bebeauty.repository.FeatureRepository;

import java.util.Optional;

@RestController
@RequestMapping("/features")
public class FeatureController {

    private final FeatureRepository repository;

    @Autowired
    public FeatureController(FeatureRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    Iterable<Feature> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Feature> findById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    Feature create(@RequestBody Feature feature) {
        return repository.save(feature);
    }

    @PutMapping("/{id}")
    Feature update(@RequestBody Feature feature) {
        return repository.save(feature);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
