package ensitpfa.backendhl.Config;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TokenRepository extends MongoRepository<Token,String> {
     Optional<Token> findTokenBy(String Token);
    Optional<Token> findTokenById(String id);

}
