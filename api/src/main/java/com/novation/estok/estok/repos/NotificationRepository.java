package com.novation.estok.estok.repos;

import com.novation.estok.estok.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
