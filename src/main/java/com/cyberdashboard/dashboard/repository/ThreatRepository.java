package com.cyberdashboard.dashboard.repository;

import com.cyberdashboard.dashboard.model.Threat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ThreatRepository extends JpaRepository<Threat, Long> {

    List<Threat> findBySeverity(String severity);
    List<Threat> findByStatus(String status);

    @Query("SELECT t FROM Threat t WHERE t.timestamp > :since ORDER BY t.timestamp DESC")
    List<Threat> findRecentThreats(@Param("since") LocalDateTime since);

    List<Threat> findAllByOrderByTimestampDesc();
    List<Threat> findTop10ByOrderByTimestampDesc();
}