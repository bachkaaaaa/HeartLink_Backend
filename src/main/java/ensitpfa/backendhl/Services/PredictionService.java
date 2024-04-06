package ensitpfa.backendhl.Services;

import ensitpfa.backendhl.Models.Prediction;
import ensitpfa.backendhl.Repositories.PredictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PredictionService {

    @Autowired
    private PredictionRepository repository;

    public List<Prediction> getAllItems() {
        return repository.findAll();
    }

    public Optional<Prediction> getItemById(String id) {
        return repository.findById(id);
    }

    public Prediction createItem(Prediction item) {
        return repository.save(item);
    }

    public void updateItem(String id, Prediction newItem) {
        newItem.setId(id); // Ensure the new item has the same ID as the existing one
        repository.save(newItem);
    }

    public void deleteItem(String id) {
        repository.deleteById(id);
    }
}
