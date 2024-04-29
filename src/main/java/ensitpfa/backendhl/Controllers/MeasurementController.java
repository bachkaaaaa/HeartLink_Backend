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


    @GetMapping("/connectedUser/{deviceId}")
    public List<Measurement> getMeasurementsByConnectedUserId(@PathVariable String deviceId) {
        return measurementService.findAllByDeviceId(deviceId);
    }

    @PostMapping
    public Measurement createMeasurement(@RequestBody Measurement measurement) {
        return measurementService.createMeasurement(measurement);
    }




}
