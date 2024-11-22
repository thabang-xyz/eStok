package com.novation.estok.estok.repos;

import com.novation.estok.estok.domain.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ContributionRepository extends JpaRepository<Contribution, Long> {}