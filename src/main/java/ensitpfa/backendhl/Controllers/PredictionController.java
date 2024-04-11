package ensitpfa.backendhl.Controllers;

import ensitpfa.backendhl.Models.Prediction;
import ensitpfa.backendhl.Services.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/predictions")
public class PredictionController {

    @Autowired
    private PredictionService predictionService;

    @GetMapping
    public List<Prediction> getAllItems() {
        return predictionService.getAllItems();
    }

    @GetMapping("/{id}")
    public Optional<Prediction> getItemById(@PathVariable String id) {
        return predictionService.getItemById(id);
    }

    @PostMapping
    public Prediction createItem(@RequestBody Prediction item) {
        return predictionService.createItem(item);
    }

    @PutMapping("/{id}")
    public void updateItem(@PathVariable String id, @RequestBody Prediction newItem) {
        predictionService.updateItem(id, newItem);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable String id) {
        predictionService.deleteItem(id);
    }
}
