package com.cyberdashboard.dashboard.controller;

import com.cyberdashboard.dashboard.model.Threat;
import com.cyberdashboard.dashboard.service.ThreatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ThreatService threatService;

    @GetMapping("/threats")
    public List<Threat> getAllThreats() {
        return threatService.getAllThreats();
    }

    @GetMapping("/stats")
    public Map<String, Object> getStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalThreats", threatService.getTotalThreats());
        stats.put("activeThreats", threatService.getActiveThreats());
        stats.put("criticalThreats", threatService.getCriticalThreats());
        stats.put("systemsOnline", 12);
        return stats;
    }
}