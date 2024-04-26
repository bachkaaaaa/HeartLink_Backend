package ensitpfa.backendhl.Services;

import ensitpfa.backendhl.Models.Alert;
import ensitpfa.backendhl.Repositories.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlertService {

    @Autowired
    private AlertRepository repository;

    public List<Alert> getAllItems() {
        return repository.findAll();
    }

    public Optional<Alert> getItemById(String id) {
        return repository.findById(id);
    }

    public Alert createItem(Alert item) {
        return repository.save(item);
    }

    public void updateItem(String id, Alert newItem) {
        newItem.setId(id);
        repository.save(newItem);
    }

    public void deleteItem(String id) {
        repository.deleteById(id);
    }
}
