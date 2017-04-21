package com.nab.hackathon.services.merchant.repository;

import com.nab.hackathon.services.merchant.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

  List<Payment> findByCustomerId(Long customerId);

  List<Payment> findByMerchantId(Long merchantId);

  List<Payment> findByBeaconId(String beaconId);

}
