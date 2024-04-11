package ensitpfa.backendhl.Controllers;

import ensitpfa.backendhl.Models.HealthData;
import ensitpfa.backendhl.Services.HealthDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/healthdata")
public class HealthDataController {

    @Autowired
    private HealthDataService healthDataService;

    @GetMapping
    public List<HealthData> getAllData() {
        return healthDataService.getAllData();
    }

    @GetMapping("/{id}")
    public Optional<HealthData> getDataById(@PathVariable String id) {
        return healthDataService.getDataById(id);
    }

    @PostMapping
    public HealthData createData(@RequestBody HealthData data) {
        return healthDataService.createData(data);
    }

    @PutMapping("/{id}")
    public void updateData(@PathVariable String id, @RequestBody HealthData newData) {
        healthDataService.updateData(id, newData);
    }

    @DeleteMapping("/{id}")
    public void deleteData(@PathVariable String id) {
        healthDataService.deleteData(id);
    }
}
