package pl.bebeauty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bebeauty.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
