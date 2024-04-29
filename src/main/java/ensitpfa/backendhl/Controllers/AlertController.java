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
        return AlertService.getAllAlerts();
    }

    @GetMapping("/{id}")
    public Optional<Alert> getAlertByPatientId(@PathVariable String id) {
        return AlertService.getAlertByPatientId(id);
    }

    @PostMapping
    public Alert createItem(@RequestBody Alert item) {
        return AlertService.createAlert(item);
    }


}
