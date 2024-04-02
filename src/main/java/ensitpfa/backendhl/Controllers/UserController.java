//package ensitpfa.backendhl.Controllers;
//
//import ensitpfa.backendhl.Services.UserService;
//import ensitpfa.backendhl.Models.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/user")
//public class UserController {
//
//    @Autowired
//   private UserService userService;
//
//    @PostMapping("/register")
//    public void registerUser(@RequestBody User user){
//            userService.createUser(user);
//
//
//    }
//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable("id") Long id,@RequestBody User user){
//        return Optional.of(userService.updateUser(id, user))
//                .map(updatedUser -> new ResponseEntity<>(updatedUser, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//    @GetMapping
//    public ResponseEntity<List<User>> getAllUsers() {
//        List<User> users = userService.getAllUsers();
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }
//
//    @GetMapping("{id}")
//    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
//       return userService.getUserById(id)
//               .map(user -> new ResponseEntity<User>(user,HttpStatus.FOUND))
//               .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//    @GetMapping("/{email}")
//    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email){
//        return userService.getUserByEmail(email)
//                .map(user->new ResponseEntity<User>(user,HttpStatus.FOUND))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
//        userService.deleteUser(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//
//}
