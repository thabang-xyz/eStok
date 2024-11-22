package com.novation.estok.estok.service;

import com.novation.estok.estok.domain.AuditLog;
import com.novation.estok.estok.model.AuditLogDTO;
import com.novation.estok.estok.repos.AuditLogRepository;
import com.novation.estok.estok.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class AuditLogService {

    private final AuditLogRepository auditLogRepository;

    public AuditLogService(final AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    public List<AuditLogDTO> findAll() {
        final List<AuditLog> auditLogs = auditLogRepository.findAll(Sort.by("id"));
        return auditLogs.stream()
                .map(auditLog -> mapToDTO(auditLog, new AuditLogDTO()))
                .toList();
    }

    public AuditLogDTO get(final Long id) {
        return auditLogRepository.findById(id)
                .map(auditLog -> mapToDTO(auditLog, new AuditLogDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final AuditLogDTO auditLogDTO) {
        final AuditLog auditLog = new AuditLog();
        mapToEntity(auditLogDTO, auditLog);
        return auditLogRepository.save(auditLog).getId();
    }

    public void update(final Long id, final AuditLogDTO auditLogDTO) {
        final AuditLog auditLog = auditLogRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(auditLogDTO, auditLog);
        auditLogRepository.save(auditLog);
    }

    public void delete(final Long id) {
        auditLogRepository.deleteById(id);
    }

    private AuditLogDTO mapToDTO(final AuditLog auditLog, final AuditLogDTO auditLogDTO) {
        auditLogDTO.setId(auditLog.getId());
        auditLogDTO.setAction(auditLog.getAction());
        return auditLogDTO;
    }

    private AuditLog mapToEntity(final AuditLogDTO auditLogDTO, final AuditLog auditLog) {
        auditLog.setAction(auditLogDTO.getAction());
        return auditLog;
    }

}
