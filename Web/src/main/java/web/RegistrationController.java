package web;

import entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import services.UserService;

import java.util.Map;

@Controller
@AllArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @GetMapping("/registration")
    public String registry() {
//        Pageable pageable = PageRequest.of(0, 2, Sort.by("id").descending());
//        List<User> all = userService.findAll(pageable);
        return "registry";
    }


    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> errorsMap) {
        boolean success = userService.registryUser(user, errorsMap);

        if (success) {
            userService.autoLogin(user);
            return "redirect:/home";
        } else {
            return "registry";
        }
    }
}
