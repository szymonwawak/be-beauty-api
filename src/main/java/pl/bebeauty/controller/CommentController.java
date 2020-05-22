package pl.bebeauty.controller;

import org.springframework.web.bind.annotation.*;
import pl.bebeauty.model.Comment;
import pl.bebeauty.repository.CommentRepository;
import pl.bebeauty.service.CommentService;

import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentRepository repository;
    private final CommentService commentService;

    public CommentController(CommentRepository repository, CommentService commentService) {
        this.repository = repository;
        this.commentService = commentService;
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
        repository.save(comment);
        commentService.setProductTotalScore(comment);
        return comment;
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
