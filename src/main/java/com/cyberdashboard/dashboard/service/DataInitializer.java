package com.cyberdashboard.dashboard.service;

import com.cyberdashboard.dashboard.model.Threat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ThreatService threatService;

    @Override
    public void run(String... args) throws Exception {
        if (threatService.getTotalThreats() == 0) {
            Threat t1 = new Threat("DDoS", "Critical", "192.168.1.105",
                    "Web Server", "DDoS attack detected", "Blocked");
            Threat t2 = new Threat("Malware", "High", "10.0.0.45",
                    "Database", "Ransomware detected", "Investigating");
            Threat t3 = new Threat("Phishing", "Medium", "172.16.1.89",
                    "Mail Server", "Phishing emails", "Detected");
            Threat t4 = new Threat("Brute Force", "High", "203.45.67.89",
                    "SSH Server", "Multiple failed logins", "Blocked");

            threatService.saveThreat(t1);
            threatService.saveThreat(t2);
            threatService.saveThreat(t3);
            threatService.saveThreat(t4);

            System.out.println("✅ Sample threat data created!");
        }
    }
}