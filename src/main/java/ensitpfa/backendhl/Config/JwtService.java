package ensitpfa.backendhl.Config;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;
import java.util.function.Function;

@Service
public class JwtService {
   private static String secretKey="BE2CD84D495D7C8E2C446D5D9E74B15A25664C7585586B654C848E";

    public String extractEmail(String token){
return extractclaim(token,Claims::getSubject);
    }

    private Claims extractAllClaims(String token){
        // Use Jwts.parserBuilder() to create a JwtParserBuilder instance
        // Use setSigningKey() to specify the signing key used to verify the JWT's signature
        // Use build() to build a JwtParser instance
        // Use parseClaimsJws() to parse the specified JWT token and verify its signature
        // Use getBody() to retrieve the claims (payload) from the JWT
        return Jwts
                .parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token) //checking
                .getBody();
    }
    public <T> T extractclaim(String token, Function<Claims,T> claimResolver){
     final Claims claims=   extractAllClaims(token);
     return claimResolver.apply(claims);
    }
    private Key getSigningKey() {
        byte[] key= Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(key);
    }

////////////////////////////////////////////////////////////
    public String generateToken(UserDetails userDetails)
    {Map<String, Object> claims = new HashMap<>();
        return generateToken(claims,userDetails);
    }
    public String generateToken(
            Map<String,Object> extraClaims,
            UserDetails userDetails){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt((new Date(System.currentTimeMillis())))
                .setExpiration((new Date(System.currentTimeMillis()+1000*60*24*30)))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();



    }
    //////////////////////////////////////////////////
    public boolean isTokenValid(String token,UserDetails userDetails ){
        String user= userDetails.getUsername();
        return Objects.equals(extractEmail(token), user) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractclaim(token,Claims::getExpiration).before(new Date(System.currentTimeMillis()));
    }

}
