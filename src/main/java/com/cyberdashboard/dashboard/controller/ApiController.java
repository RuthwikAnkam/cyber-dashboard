package com.cyberdashboard.dashboard.controller;

import com.cyberdashboard.dashboard.model.Threat;
import com.cyberdashboard.dashboard.service.ThreatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ThreatService threatService;

    @GetMapping("/threats")
    public List<Threat> getAllThreats() {
        return threatService.getAllThreats();
    }

    @GetMapping("/threats/recent")
    public List<Threat> getRecentThreats() {
        return threatService.getRecentThreats();
    }

    @GetMapping("/stats")
    public java.util.Map<String, Object> getStats() {
        java.util.Map<String, Object> stats = new java.util.HashMap<>();
        stats.put("totalThreats", threatService.getTotalThreats());
        stats.put("activeThreats", threatService.getActiveThreats());
        stats.put("criticalThreats", threatService.getCriticalThreats());
        stats.put("systemsOnline", 12);
        return stats;
    }
}