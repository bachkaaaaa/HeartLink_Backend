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
    private Integer serumCholesterol;
    private Integer fastingBloodSugar;
    private Integer exerciseAngina;
    private Integer noMajorVessels;
    private User user;






}
