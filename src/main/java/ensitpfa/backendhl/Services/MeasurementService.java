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


    public List<Measurement> findAllByDeviceId(String connectedUserId) {
        return repository.findAllByDeviceId(connectedUserId);
    }

    public Measurement createMeasurement(Measurement measurement) {
        return repository.save(measurement);
    }
}


