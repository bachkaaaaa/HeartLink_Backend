package ensitpfa.backendhl.Repositories;

import ensitpfa.backendhl.Models.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends MongoRepository<Patient,String> {
    Optional<Patient> findPatientByEmail(String email);
    List<Patient> findPatientByRole(Config.Role role);

}
