package com.nab.hackathon.services.beacon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pasapicella on 4/20/17.
 */
public interface MerchantRepository extends JpaRepository <com.nab.hackathon.services.beacon.entity.Merchant, Long> {

}
