package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import services.CarService;


@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping()
    public String home() {
        return "home";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
