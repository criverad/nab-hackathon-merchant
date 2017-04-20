package com.nab.hackathon.services.merchant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pasapicella on 4/20/17.
 */
public interface MerchantRepository extends JpaRepository <com.nab.hackathon.services.merchant.entity.Merchant, Long> {

}
