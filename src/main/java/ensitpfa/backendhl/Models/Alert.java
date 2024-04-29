package ensitpfa.backendhl.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("Alert")
public class Alert {
    @Id
    private String id;
    private Date timeStamp;
    private String message;
    private Patient patient;
    private Device device;
}
