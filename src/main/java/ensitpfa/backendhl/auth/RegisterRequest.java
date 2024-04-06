package ensitpfa.backendhl.auth;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class RegisterRequest {
    public String id;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private Integer age;
    private Integer gender;
    private Integer height;
    private Integer weight;
}
