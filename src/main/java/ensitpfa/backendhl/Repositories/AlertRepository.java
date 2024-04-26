package ensitpfa.backendhl.Repositories;

import ensitpfa.backendhl.Models.Alert;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface AlertRepository extends MongoRepository<Alert, String> {
    }
