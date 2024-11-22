package com.novation.estok.estok.repos;

import com.novation.estok.estok.domain.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
}
