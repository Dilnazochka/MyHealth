package kg.alatoo.myhealth.controller;


import kg.alatoo.myhealth.entity.User;
import kg.alatoo.myhealth.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    private final UserService userService;
    public AuthController(UserService userService){ this.userService = userService; }

    @GetMapping("/login") public String login(){ return "login"; }

    @GetMapping("/register")
    public String registerForm(Model m){ m.addAttribute("user", new User()); return "register"; }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute User user, Model model){
        if (userService.findByEmail(user.getEmail()).isPresent()){
            model.addAttribute("error","Email already registered");
            return "register";
        }
        userService.register(user);
        // TODO: send verification email with token
        model.addAttribute("success","Registered. Please verify email (dev: manually enable in DB)");
        return "login";
    }
}