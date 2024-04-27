package ensitpfa.backendhl.Controllers;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;


@CrossOrigin
@RestController
public class ModelController{


    @PostMapping("/forward")
    public ResponseEntity<String> forwardJson(@RequestBody String json) {
        String destinationUrl = "http://localhost:5000/predict";


        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(json, headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.exchange(
                destinationUrl,
                HttpMethod.POST,
                entity,
                String.class
        );

        return response;
    }
}