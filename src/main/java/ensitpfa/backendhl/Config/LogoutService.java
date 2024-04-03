package ensitpfa.backendhl.Config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {
    private final JwtService jwtService;

    private final TokenRepository tokenRepository;

    @Override
    public void logout(HttpServletRequest request
            , HttpServletResponse response
            , Authentication authentication) {
        final String authHeader=request.getHeader("Authorization");
        final String jwt;
        if(authHeader==null||!authHeader.startsWith("Bearer ")){
            return;
        }
        jwt=authHeader.substring(7);
       var storedToken=tokenRepository.findTokenBy(jwt)
               .orElse(null);
        if (storedToken != null) {
            storedToken.setLoggedOut(true);
            tokenRepository.save(storedToken);
        }
    }
}
