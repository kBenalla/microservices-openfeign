package org.com.microservicepayment.repository;

import org.com.microservicepayment.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    Optional<Payment> findByCommandId(Integer commandId);
}
