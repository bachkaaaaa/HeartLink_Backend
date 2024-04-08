package ensitpfa.backendhl.Repositories;

import ensitpfa.backendhl.Models.Prediction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface PredictionRepository extends MongoRepository<Prediction, String> {
    }
