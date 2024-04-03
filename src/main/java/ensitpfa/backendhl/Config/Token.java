package ensitpfa.backendhl.Config;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Builder
@Document("Token")
public class Token {
    @Id
    private String id;
    private String token;
    private boolean loggedOut;
}
