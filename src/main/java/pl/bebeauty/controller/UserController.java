package pl.bebeauty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.bebeauty.model.User;
import pl.bebeauty.repository.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repository;

    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    Iterable<User> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Optional<User> findById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    User create(@RequestBody User user) {
        return repository.save(user);
    }

    @PutMapping
    User update(@RequestBody User user) {
        return repository.save(user);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable  Long id) {
        repository.deleteById(id);
    }
}
