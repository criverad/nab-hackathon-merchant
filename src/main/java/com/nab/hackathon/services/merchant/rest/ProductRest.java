package com.nab.hackathon.services.merchant.rest;

import com.nab.hackathon.services.merchant.entity.Product;
import com.nab.hackathon.services.merchant.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/product")
public class ProductRest {

  @Autowired
  private ProductRepository productRepository;

  @RequestMapping(value = "all", method = GET, produces = APPLICATION_JSON_VALUE)
  public List<Product> allProducts() {
    return productRepository.findAll();
  }

  @RequestMapping(value = "/{productId}", method = GET, produces = APPLICATION_JSON_VALUE)
  public Product findByProductId(@PathVariable("productId") Long productId) {
    return productRepository.findOne(productId);
  }

  @RequestMapping(value = "/merchant/{merchantId}", method = GET, produces = APPLICATION_JSON_VALUE)
  public List<Product> findByMerchantId(@PathVariable("merchantId") Long merchantId) {
    return productRepository.findByMerchantId(merchantId);
  }

  @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  public Product create(@RequestBody Product product) {
    return productRepository.save(product);
  }

  @RequestMapping(value = "/{productId}", method = DELETE)
  public void delete(@PathVariable("productId") Long productId) {
    productRepository.delete(productId);
  }

}
