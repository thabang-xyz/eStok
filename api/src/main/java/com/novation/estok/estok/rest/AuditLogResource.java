package com.novation.estok.estok.rest;

import com.novation.estok.estok.model.AuditLogDTO;
import com.novation.estok.estok.service.AuditLogService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/auditLogs", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuditLogResource {

    private final AuditLogService auditLogService;

    public AuditLogResource(final AuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    @GetMapping
    public ResponseEntity<List<AuditLogDTO>> getAllAuditLogs() {
        return ResponseEntity.ok(auditLogService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditLogDTO> getAuditLog(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(auditLogService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createAuditLog(@RequestBody @Valid final AuditLogDTO auditLogDTO) {
        final Long createdId = auditLogService.create(auditLogDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateAuditLog(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final AuditLogDTO auditLogDTO) {
        auditLogService.update(id, auditLogDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuditLog(@PathVariable(name = "id") final Long id) {
        auditLogService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
