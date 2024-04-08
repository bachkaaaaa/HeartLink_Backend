package ensitpfa.backendhl.Repositories;

import ensitpfa.backendhl.Models.HealthData;
import ensitpfa.backendhl.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface HealthDataRepository extends MongoRepository<HealthData, String> {
    public Optional<HealthData> findHealthDataByUser(User user);
}
