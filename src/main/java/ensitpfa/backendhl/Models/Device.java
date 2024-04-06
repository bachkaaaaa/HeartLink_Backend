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
@Document("Device")
public class Device {
    @Id
    @GeneratedValue
    private String id;
    private String device;
    private Date timeStamp;
    private boolean isConnected;
    private User connectedUser;
}
