package com.novation.estok.estok.service;

import com.novation.estok.estok.domain.Attendance;
import com.novation.estok.estok.model.AttendanceDTO;
import com.novation.estok.estok.repos.AttendanceRepository;
import com.novation.estok.estok.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceService(final AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public List<AttendanceDTO> findAll() {
        final List<Attendance> attendances = attendanceRepository.findAll(Sort.by("id"));
        return attendances.stream()
                .map(attendance -> mapToDTO(attendance, new AttendanceDTO()))
                .toList();
    }

    public AttendanceDTO get(final Long id) {
        return attendanceRepository.findById(id)
                .map(attendance -> mapToDTO(attendance, new AttendanceDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final AttendanceDTO attendanceDTO) {
        final Attendance attendance = new Attendance();
        mapToEntity(attendanceDTO, attendance);
        return attendanceRepository.save(attendance).getId();
    }

    public void update(final Long id, final AttendanceDTO attendanceDTO) {
        final Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(attendanceDTO, attendance);
        attendanceRepository.save(attendance);
    }

    public void delete(final Long id) {
        attendanceRepository.deleteById(id);
    }

    private AttendanceDTO mapToDTO(final Attendance attendance, final AttendanceDTO attendanceDTO) {
        attendanceDTO.setId(attendance.getId());
        attendanceDTO.setPresent(attendance.getPresent());
        return attendanceDTO;
    }

    private Attendance mapToEntity(final AttendanceDTO attendanceDTO, final Attendance attendance) {
        attendance.setPresent(attendanceDTO.getPresent());
        return attendance;
    }

}
