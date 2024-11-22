package com.novation.estok.estok.repos;

import com.novation.estok.estok.domain.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}
