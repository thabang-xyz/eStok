package com.novation.estok.estok.repos;

import com.novation.estok.estok.domain.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
