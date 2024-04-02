//package ensitpfa.backendhl.Services;
//
//import ensitpfa.backendhl.Models.User;
//import ensitpfa.backendhl.Repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Example;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserService {
//    @Autowired
//    private UserRepository userRepository;
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    public Optional<User> getUserById(Long id) {
//        return userRepository.findById(id);
//    }
//    public static Optional<User> getUserByEmail(String email) {
//        User user =new User();
//        user.setEmail(email);
//        Example<User> userExample=Example.of(user);
//        return userRepository.findOne(userExample);
//    }
//
//    public void createUser(User user) {
//        userRepository.save(user);
//    }
//
//    public User updateUser(Long id, User user) {
//        if (userRepository.existsById(id)) {
//            user.setId(id);
//            return userRepository.save(user);
//        } else {
//            throw new RuntimeException("User not found with id: " + id);
//        }
//    }
//
//    public void deleteUser(Long id) {
//        userRepository.deleteById(id);
//    }
//}
