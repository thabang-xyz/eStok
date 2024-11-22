package com.novation.estok.estok.repos;

import com.novation.estok.estok.domain.Expence;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExpenceRepository extends JpaRepository<Expence, Long> {
}
