package ensitpfa.backendhl.Repositories;

import ensitpfa.backendhl.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findUserByEmail(String email);
}
