package ensitpfa.backendhl.Repositories;

import ensitpfa.backendhl.Models.HealthData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthDataRepository extends MongoRepository<HealthData, String> {
}
