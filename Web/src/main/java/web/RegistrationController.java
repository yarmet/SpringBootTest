package web;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import services.UserService;

import java.util.Map;

@Controller
public class RegistrationController {


    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registry() {
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
