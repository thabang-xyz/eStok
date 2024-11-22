package com.novation.estok.estok.repos;

import com.novation.estok.estok.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account, Long> {
}
