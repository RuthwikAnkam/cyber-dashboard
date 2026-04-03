package com.cyberdashboard.dashboard.service;

import com.cyberdashboard.dashboard.model.Threat;
import com.cyberdashboard.dashboard.repository.ThreatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ThreatService {

    @Autowired
    private ThreatRepository threatRepository;

    public List<Threat> getAllThreats() {
        return threatRepository.findAllByOrderByTimestampDesc();
    }

    public List<Threat> getRecentThreats() {
        return threatRepository.findTop10ByOrderByTimestampDesc();
    }

    public long getTotalThreats() {
        return threatRepository.count();
    }

    public long getCriticalThreats() {
        return threatRepository.findBySeverity("Critical").size();
    }

    public long getActiveThreats() {
        return threatRepository.findByStatus("Detected").size() +
                threatRepository.findByStatus("Investigating").size();
    }

    public Threat saveThreat(Threat threat) {
        return threatRepository.save(threat);
    }
}