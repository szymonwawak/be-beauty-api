package pl.bebeauty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.bebeauty.model.Comment;
import pl.bebeauty.repository.CommentRepository;

import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentRepository repository;

    @Autowired
    public CommentController(CommentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    Iterable<Comment> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Comment> findById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    Comment create(@RequestBody Comment comment) {
        return repository.save(comment);
    }

    @PutMapping
    Comment update(@RequestBody Comment comment) {
        return repository.save(comment);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
