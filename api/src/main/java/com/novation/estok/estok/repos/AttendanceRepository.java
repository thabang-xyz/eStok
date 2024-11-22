package com.novation.estok.estok.repos;

import com.novation.estok.estok.domain.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
