package ensitpfa.backendhl.Repositories;

import ensitpfa.backendhl.Models.Device;
import ensitpfa.backendhl.Models.Measurement;
import ensitpfa.backendhl.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface MeasurementRepository extends MongoRepository< Measurement,String>
{
    List<Measurement> findAllByConnectedUserId(String connectedUserId);
}
