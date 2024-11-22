package com.novation.estok.estok.repos;

import com.novation.estok.estok.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
