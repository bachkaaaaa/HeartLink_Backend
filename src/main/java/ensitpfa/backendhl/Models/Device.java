package ensitpfa.backendhl.Models;

import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Period;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("Device")
public class Device {
    @Id
    @GeneratedValue
    private String id;
    private boolean isConnected;
    private Period measureIntervalle;
    private Patient connectedUser;
    private List<Measurement> measurementList;

}
