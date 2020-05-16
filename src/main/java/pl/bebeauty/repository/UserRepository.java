package pl.bebeauty.repository;

import org.springframework.data.repository.CrudRepository;
import pl.bebeauty.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
