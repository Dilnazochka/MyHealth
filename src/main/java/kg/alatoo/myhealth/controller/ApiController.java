package kg.alatoo.myhealth.controller;


import kg.alatoo.myhealth.entity.MedicalTest;
import kg.alatoo.myhealth.entity.User;
import kg.alatoo.myhealth.security.CustomUserDetails;
import kg.alatoo.myhealth.service.MedicalTestService;
import kg.alatoo.myhealth.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final MedicalTestService testService;
    private final UserService userService;
    public ApiController(MedicalTestService t, UserService u){ this.testService = t; this.userService = u; }

    @GetMapping("/public/ping")
    public ResponseEntity<String> ping(){ return ResponseEntity.ok("pong"); }

    @GetMapping("/tests")
    public ResponseEntity<List<MedicalTest>> getTests(@AuthenticationPrincipal CustomUserDetails userDetails){
        User u = userService.findById(userDetails.getId());
        return ResponseEntity.ok(testService.findByUser(u));
    }
    // POST /api/tests (create)
    @PostMapping("/tests")
    public ResponseEntity<MedicalTest> createTest(@RequestBody MedicalTest test, @AuthenticationPrincipal CustomUserDetails userDetails){
        User u = userService.findById(userDetails.getId());
        test.setUser(u);
        MedicalTest saved = testService.create(test);
        return ResponseEntity.ok(saved);
    }
}