package ensitpfa.backendhl.Controllers;

import ensitpfa.backendhl.Models.Alert;
import ensitpfa.backendhl.Services.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Alerts")
public class AlertController {

    @Autowired
    private AlertService AlertService;

    @GetMapping
    public List<Alert> getAllItems() {
        return AlertService.getAllItems();
    }

    @GetMapping("/{id}")
    public Optional<Alert> getItemById(@PathVariable String id) {
        return AlertService.getItemById(id);
    }

    @PostMapping
    public Alert createItem(@RequestBody Alert item) {
        return AlertService.createItem(item);
    }

    @PutMapping("/{id}")
    public void updateItem(@PathVariable String id, @RequestBody Alert newItem) {
        AlertService.updateItem(id, newItem);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable String id) {
        AlertService.deleteItem(id);
    }
}
