package ensitpfa.backendhl.Controllers;

import com.mongodb.internal.connection.Time;
import ensitpfa.backendhl.Models.Alert;
import ensitpfa.backendhl.Models.Measurement;
import ensitpfa.backendhl.Services.AlertService;
import ensitpfa.backendhl.Services.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.util.Collections;
import java.util.Map;


@CrossOrigin
@RestController
public class ModelController{
    @Autowired
    private ensitpfa.backendhl.Services.AlertService alertService;
    @Autowired
    private MeasurementService measurementService;

    @PostMapping("/forward")
    public ResponseEntity<String> forwardJson(@RequestBody Measurement json) {
        String destinationUrl = "http://localhost:5000/predict";

        measurementService.createMeasurement(json);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity<Measurement> entity = new HttpEntity<>(json, headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.exchange(
                destinationUrl,
                HttpMethod.POST,
                entity,
                String.class
        );
        if(!(response.getBody().contains("Absence"))) {
            var list=json.getDevice().getConnectedUser();

            alertService.createAlert(
                    Alert.builder()
                    .device(json.getDevice())
                    .patient(Collections.max(list.entrySet(), Map.Entry.comparingByValue()).getKey())
                            .message("Be careful There are Abnormal insights").build());
        }

            return response;
    }
}