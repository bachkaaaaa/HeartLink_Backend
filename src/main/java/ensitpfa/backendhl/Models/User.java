package ensitpfa.backendhl.Models;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("user")


public class User implements UserDetails {
    @Id
    @GeneratedValue
    public String id;
    private      String lastName;
    private     String firstName;
    private     String email;
    private     String password;
    @Enumerated(EnumType.STRING)
    private Config.Role role;
    private Integer age;
    private Integer gender;
    private Integer height;
    private Integer weight;
    private Device connectedDevice;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return (List.of(new SimpleGrantedAuthority(role.name())));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
