package com.nab.hackathon.services.merchant.rest;

import com.nab.hackathon.services.merchant.entity.Customer;
import com.nab.hackathon.services.merchant.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@CrossOrigin
@RestController
@RequestMapping(value = "/customer")
public class CustomerRest {

  @Autowired
  private CustomerRepository customerRepository;

  @RequestMapping(value = "all", method = GET, produces = APPLICATION_JSON_VALUE)
  public List<Customer> all() {
    return customerRepository.findAll();
  }

  @RequestMapping(value = "/{customerId}", method = GET, produces = APPLICATION_JSON_VALUE)
  public Customer findByCustomerId(@PathVariable("customerId") Long customerId) {
    return customerRepository.findOne(customerId);
  }

  @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  public Customer create(@RequestBody Customer customer) {
    return customerRepository.save(customer);
  }

  @RequestMapping(value = "/{customerId}", method = DELETE)
  public void delete(@PathVariable("customerId") Long customerId) {
    customerRepository.delete(customerId);
  }

}
