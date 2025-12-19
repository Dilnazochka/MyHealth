package kg.alatoo.myhealth.controller;


import kg.alatoo.myhealth.entity.MedicalTest;
import kg.alatoo.myhealth.entity.User;
import kg.alatoo.myhealth.security.CustomUserDetails;
import kg.alatoo.myhealth.service.MedicalTestService;
import kg.alatoo.myhealth.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class DashboardController {
    private final MedicalTestService testService;
    private final UserService userService;
    public DashboardController(MedicalTestService t, UserService u){ this.testService = t; this.userService = u; }

    @GetMapping({"/","/dashboard"})
    public String dashboard(@AuthenticationPrincipal CustomUserDetails userDetails, Model model){
        User user = userService.findById(userDetails.getId());
        List<MedicalTest> tests = testService.findByUser(user);
        model.addAttribute("tests", tests);
        model.addAttribute("userName", user.getName());


        Map<String, List<MedicalTest>> grouped = tests.stream().collect(Collectors.groupingBy(MedicalTest::getTestType));
        if (!grouped.isEmpty()) {
            String first = grouped.keySet().iterator().next();
            List<MedicalTest> series = grouped.get(first);
            List<Double> values = series.stream().map(MedicalTest::getValue).collect(Collectors.toList());
            List<String> labels = series.stream().map(t -> t.getTestDate().toString()).collect(Collectors.toList());
            model.addAttribute("chartValues", values);
            model.addAttribute("chartLabels", labels);
            model.addAttribute("chartType", first);
        }
        return "dashboard";
    }
}