package com.nab.hackathon.services.merchant.repository;

import com.nab.hackathon.services.merchant.entity.BeaconProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeaconProductRepository extends JpaRepository<BeaconProduct, BeaconProduct.BeaconProductId> {

  List<BeaconProduct> findByBeaconProductIdBeaconId(String beaconId);

}
