package ensitpfa.backendhl.Repositories;

import ensitpfa.backendhl.Models.Alert;
import ensitpfa.backendhl.Models.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface AlertRepository extends MongoRepository<Alert, String> {
    Optional<Alert>findAlertByPatientId(String patient);
    }
