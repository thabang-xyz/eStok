package com.novation.estok.estok.repos;

import com.novation.estok.estok.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
