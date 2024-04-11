package ensitpfa.backendhl.Services;

import ensitpfa.backendhl.Models.HealthData;
import ensitpfa.backendhl.Repositories.HealthDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class HealthDataService  {

    @Autowired
    private HealthDataRepository repository;

    public List<HealthData> getAllData() {
        return repository.findAll();
    }

    public Optional<HealthData> getDataById(String id) {
        return repository.findById(id);
    }

    public HealthData createData(HealthData data) {
        return repository.save(data);
    }

    public void updateData(String id, HealthData newData) {
        newData.setId(id);
        repository.save(newData);
    }

    public void deleteData(String id) {
        repository.deleteById(id);
    }
}