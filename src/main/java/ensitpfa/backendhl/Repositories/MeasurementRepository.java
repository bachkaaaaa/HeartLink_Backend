package ensitpfa.backendhl.Repositories;

import ensitpfa.backendhl.Models.Device;
import ensitpfa.backendhl.Models.Measurement;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MeasurementRepository extends MongoRepository<String, Measurement>
{

}
