package ensitpfa.backendhl.Services;

import ensitpfa.backendhl.Controllers.ModelRestTemplate;
import ensitpfa.backendhl.Models.Measurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;


@CrossOrigin
@RestController
public class ModelService {

//    @GetMapping("/detection")
//    public String performDetection() {
//        // URL du serveur Python
//        String pythonServerUrl = "http://localhost:5000/predict";
//
//        // Effectuez une requête HTTP GET vers le serveur Python
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject(pythonServerUrl, String.class);
//
//        // Retournez la réponse reçue du serveur Python
//        return response;
//    }
    @PostMapping("/forward")
    public ResponseEntity<String> forwardJson(@RequestBody String json) {
        // URL of the server to forward the JSON to
        String destinationUrl = "http://localhost:5000/predict";

        // Set headers

        // Create HTTP entity with JSON content and headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

// Create HttpEntity with the JSON body and headers
        HttpEntity<String> entity = new HttpEntity<>(json, headers);
        RestTemplate restTemplate = new RestTemplate();

        // Send POST request to the destination server
        ResponseEntity<String> response = restTemplate.exchange(
                destinationUrl,
                HttpMethod.POST,
                entity,
                String.class
        );

        // Return the response received from the destination server
        return response;
    }
}