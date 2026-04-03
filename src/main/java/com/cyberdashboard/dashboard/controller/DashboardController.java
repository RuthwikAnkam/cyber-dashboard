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

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        // Fetch REAL data from database via ThreatService
        List<Threat> threats = threatService.getAllThreats();
        long totalThreats = threatService.getTotalThreats();
        long activeThreats = threatService.getActiveThreats();
        long criticalThreats = threatService.getCriticalThreats();

        // Add REAL data to model
        model.addAttribute("username", "Security Analyst");
        model.addAttribute("totalThreats", totalThreats);
        model.addAttribute("activeThreats", activeThreats);
        model.addAttribute("blockedThreats", 8); // We'll fix this later
        model.addAttribute("criticalThreats", criticalThreats);
        model.addAttribute("systemsOnline", 12);
        model.addAttribute("recentThreats", threats); // REAL threats from database

        return "dashboard";
    }
}