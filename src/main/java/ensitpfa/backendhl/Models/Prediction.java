package ensitpfa.backendhl.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("Prediction")
public class Prediction {
    @Id
    private String id;
    private Date timeStamp;
    private String message;
}
