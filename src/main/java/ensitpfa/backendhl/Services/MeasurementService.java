package ensitpfa.backendhl.Services;

import ensitpfa.backendhl.Models.Measurement;
import ensitpfa.backendhl.Repositories.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {

    @Autowired
    private MeasurementRepository repository;

    public List<Measurement> getAllMeasurements() {
        return repository.findAll();
    }

    public Optional<Measurement> getMeasurementById(String id) {
        return repository.findById(id);
    }

    public List<Measurement> getMeasurementsByConnectedUserId(String connectedUserId) {
        return repository.findAllByConnectedUserId(connectedUserId);
    }

    public Measurement createMeasurement(Measurement measurement) {
        return repository.save(measurement);
    }

    public void updateMeasurement(String id, Measurement newMeasurement) {
        newMeasurement.setId(id);
        repository.save(newMeasurement);
    }

    public void deleteMeasurement(String id) {
        repository.deleteById(id);
    }
}
