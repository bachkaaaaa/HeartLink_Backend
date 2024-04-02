package ensitpfa.backendhl.auth;

import lombok.*;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AuthenticationResponse {
    private String token;
}
