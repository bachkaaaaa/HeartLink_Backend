package ensitpfa.backendhl.Services;

import ensitpfa.backendhl.Models.User;
import ensitpfa.backendhl.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class UserService {
   final private UserRepository userRepository;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }
    public  Optional<User> getUserByEmail(String email) {

        return userRepository.findUserByEmail(email);
    }


    public User editUser(String id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
    public void checkStatistics(){
        return;
    }
}
