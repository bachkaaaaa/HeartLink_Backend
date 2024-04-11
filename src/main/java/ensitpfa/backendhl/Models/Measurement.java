package ensitpfa.backendhl.Models;

import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("Measurement")
public class Measurement {
    @Id
    @GeneratedValue
    private String id;
    private User connectedUser;
    private Date timestamp;
    private Integer restingBP;
    private Integer restingElectro;
    private Integer maxHeartRate;
    private Double oldPeak;
    private Integer slope;
}
