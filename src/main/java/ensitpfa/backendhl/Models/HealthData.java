package ensitpfa.backendhl.Models;

import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("HealthData")
public class HealthData {
    @Id
    @GeneratedValue
    private String id;
    private Integer chestPain;
    private Integer restingBP;
    private Integer serumCholesterol;
    private Integer fastingBloodSugar;
    private Integer restingElectro;
    private Integer maxHeartRate;
    private Integer exerciseAngina;
    private Double oldPeak;
    private Integer slope;
    private Integer noMajorVessels;
}
