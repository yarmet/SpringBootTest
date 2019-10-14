package web;

import entities.Role;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import repositories.UserRepository;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registry() {
        return "registry";
    }


    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> map) {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null) {
            map.put("message", "user exists!");
            return "registry";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(new BCryptPasswordEncoder(10).encode(user.getPassword()));
        userRepository.save(user);

        return "redirect:/home";
    }
}
