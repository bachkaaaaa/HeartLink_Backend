package ensitpfa.backendhl.auth;

import Config.Role;
import ensitpfa.backendhl.Config.JwtService;
import ensitpfa.backendhl.Config.Token;
import ensitpfa.backendhl.Config.TokenRepository;
import ensitpfa.backendhl.Models.User;
import ensitpfa.backendhl.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    final UserRepository userRepository;
    final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final TokenRepository tokenRepository;

    public AuthenticationResponse register(RegisterRequest registerRequest){
        var user= User.builder().firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken=jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();

    }
        public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken
                        (authenticationRequest.getEmail(),
                                authenticationRequest.getPassword())
        );
        var user=userRepository.findUserByEmail(authenticationRequest.getEmail())
                .orElseThrow();
        var jwtToken=jwtService.generateToken(user);
        var token= Token
                .builder()
                .token(jwtToken)
                .loggedOut(false)
                .build();
        tokenRepository.save(token);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
