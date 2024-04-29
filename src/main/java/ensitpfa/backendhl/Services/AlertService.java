package ensitpfa.backendhl.Services;

import ensitpfa.backendhl.Models.Alert;
import ensitpfa.backendhl.Models.Patient;
import ensitpfa.backendhl.Repositories.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlertService {

    @Autowired
    private AlertRepository repository;

    public List<Alert> getAllAlerts() {
        return repository.findAll();
    }


    public Optional<Alert> getAlertByPatientId(String patient) {
        return repository.findAlertByPatientId(patient);
    }

    public Alert createAlert(Alert item) {
        return repository.save(item);
    }}



