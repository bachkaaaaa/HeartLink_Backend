package ensitpfa.backendhl.Config;

import ensitpfa.backendhl.Models.User;
//import ensitpfa.backendhl.Services.UserService;
import jakarta.annotation.Nonnull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import javax.servlet.http.*;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtAuthFIlter extends OncePerRequestFilter {
    private final JwtService jwtService; //to manipulate JWTtoken
    final private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain)
            throws ServletException, IOException
    {
        if(request.getServletPath().contains("12")){
            filterChain.doFilter(request,response);
            return;
        }
        final String authHeader=request.getHeader("Authorization");
        final String jwt;
        final String userEmail;
        if(authHeader==null||!authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }
        jwt=authHeader.substring(7);
        userEmail = jwtService.extractEmail(jwt);
        if(userEmail!=null&& SecurityContextHolder.getContext().getAuthentication()==null)
        {
            UserDetails user=this.userDetailsService.loadUserByUsername(userEmail);
            if(jwtService.isTokenValid(jwt,user)){
                UsernamePasswordAuthenticationToken authToken=
                        new UsernamePasswordAuthenticationToken(user,
                                null,
                                user.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource()
                        .buildDetails(request) );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request,response);

    }




}
