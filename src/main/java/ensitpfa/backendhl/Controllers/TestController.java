package ensitpfa.backendhl.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class TestController {
    @GetMapping
    public ResponseEntity<String>hello(){
        return ResponseEntity.ok("hellllloo");
    }
}
