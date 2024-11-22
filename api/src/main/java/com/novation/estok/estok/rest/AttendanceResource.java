package com.novation.estok.estok.rest;

import com.novation.estok.estok.model.AttendanceDTO;
import com.novation.estok.estok.service.AttendanceService;
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
@RequestMapping(value = "/api/attendances", produces = MediaType.APPLICATION_JSON_VALUE)
public class AttendanceResource {

    private final AttendanceService attendanceService;

    public AttendanceResource(final AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping
    public ResponseEntity<List<AttendanceDTO>> getAllAttendances() {
        return ResponseEntity.ok(attendanceService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttendanceDTO> getAttendance(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(attendanceService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createAttendance(
            @RequestBody @Valid final AttendanceDTO attendanceDTO) {
        final Long createdId = attendanceService.create(attendanceDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateAttendance(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final AttendanceDTO attendanceDTO) {
        attendanceService.update(id, attendanceDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable(name = "id") final Long id) {
        attendanceService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
