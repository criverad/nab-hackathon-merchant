package com.nab.hackathon.services.merchant.repository;

import com.nab.hackathon.services.merchant.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
