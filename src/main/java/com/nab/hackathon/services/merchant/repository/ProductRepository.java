package com.nab.hackathon.services.merchant.repository;

import com.nab.hackathon.services.merchant.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

  List<Product> findByMerchantId(Long merchantId);

}
