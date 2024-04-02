package ensitpfa.backendhl.auth;

import lombok.*;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class RegisterRequest {
    private     String lastName;
    private     String firstName;
    private     String email;
    private     String password;
}
