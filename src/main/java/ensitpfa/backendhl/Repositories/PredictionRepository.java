package ensitpfa.backendhl.Repositories;

import ensitpfa.backendhl.Models.Prediction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PredictionRepository extends MongoRepository<Prediction, String> {
    }
