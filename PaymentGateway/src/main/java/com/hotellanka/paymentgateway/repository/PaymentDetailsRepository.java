package com.hotellanka.paymentgateway.repository;
import com.hotellanka.paymentgateway.Entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentDetailsRepository extends JpaRepository<PaymentEntity, Long> {
    List<PaymentEntity> findAllByCardNumber(String cardNumber);
}


