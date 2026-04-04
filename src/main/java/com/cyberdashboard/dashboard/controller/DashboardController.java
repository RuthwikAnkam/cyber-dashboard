package com.cyberdashboard.dashboard.controller;

import com.cyberdashboard.dashboard.model.Threat;
import com.cyberdashboard.dashboard.service.ThreatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private ThreatService threatService;

    @GetMapping("/")
    public String home(Model model) {
        return dashboard(model);
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Threat> threats = threatService.getAllThreats();

        model.addAttribute("username", "Security Analyst");
        model.addAttribute("totalThreats", threatService.getTotalThreats());
        model.addAttribute("activeThreats", threatService.getActiveThreats());
        model.addAttribute("criticalThreats", threatService.getCriticalThreats());
        model.addAttribute("systemsOnline", 12);
        model.addAttribute("recentThreats", threats);

        return "dashboard";
    }
}