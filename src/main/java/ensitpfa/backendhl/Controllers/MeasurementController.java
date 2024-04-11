package ensitpfa.backendhl.Controllers;

import ensitpfa.backendhl.Models.Measurement;
import ensitpfa.backendhl.Services.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/measurements")
public class MeasurementController {

    @Autowired
    private MeasurementService measurementService;

    @GetMapping
    public List<Measurement> getAllMeasurements() {
        return measurementService.getAllMeasurements();
    }

    @GetMapping("/{id}")
    public Optional<Measurement> getMeasurementById(@PathVariable String id) {
        return measurementService.getMeasurementById(id);
    }

    @GetMapping("/connectedUser/{connectedUserId}")
    public List<Measurement> getMeasurementsByConnectedUserId(@PathVariable String connectedUserId) {
        return measurementService.getMeasurementsByConnectedUserId(connectedUserId);
    }

    @PostMapping
    public Measurement createMeasurement(@RequestBody Measurement measurement) {
        return measurementService.createMeasurement(measurement);
    }

    @PutMapping("/{id}")
    public void updateMeasurement(@PathVariable String id, @RequestBody Measurement newMeasurement) {
        measurementService.updateMeasurement(id, newMeasurement);
    }

    @DeleteMapping("/{id}")
    public void deleteMeasurement(@PathVariable String id) {
        measurementService.deleteMeasurement(id);
    }
}
