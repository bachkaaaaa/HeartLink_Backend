package ensitpfa.backendhl.Repositories;

import ensitpfa.backendhl.Models.Measurement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasurementRepository extends MongoRepository< Measurement,String>
{
    List<Measurement> findAllByConnectedUserId(String connectedUserId);
}
