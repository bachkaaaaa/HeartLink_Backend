package ensitpfa.backendhl.Services;

import ensitpfa.backendhl.Models.Patient;
import ensitpfa.backendhl.Repositories.PatientRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class PatientService {
   final private PatientRepository patientRepository;
    public List<Patient> viewAllPatientList() {
        return patientRepository.findPatientByRole(Config.Role.USER);
    }




    public void checkStatistics(){
        return;
    }
}
