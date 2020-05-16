package pl.bebeauty.repository;

import org.springframework.data.repository.CrudRepository;
import pl.bebeauty.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
