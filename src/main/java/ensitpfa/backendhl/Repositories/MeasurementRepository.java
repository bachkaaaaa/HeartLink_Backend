package ensitpfa.backendhl.Repositories;

import ensitpfa.backendhl.Models.Device;
import ensitpfa.backendhl.Models.Measurement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface MeasurementRepository extends MongoRepository< Measurement,String>
{

}
