package kg.alatoo.myhealth.controller;


import kg.alatoo.myhealth.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    private final UserRepository userRepo;
    public AdminController(UserRepository userRepo){ this.userRepo = userRepo; }

    @GetMapping("/admin/users")
    public String users(Model m){ m.addAttribute("users", userRepo.findAll()); return "admin-users"; }
}