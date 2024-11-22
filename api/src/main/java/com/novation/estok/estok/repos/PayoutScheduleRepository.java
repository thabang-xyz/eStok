package com.novation.estok.estok.repos;

import com.novation.estok.estok.domain.PayoutSchedule;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PayoutScheduleRepository extends JpaRepository<PayoutSchedule, Long> {
}
