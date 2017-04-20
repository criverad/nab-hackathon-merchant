package com.nab.hackathon.services.merchant.repository;

import com.nab.hackathon.services.merchant.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {

}
