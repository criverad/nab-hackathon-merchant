package com.nab.hackathon.services.merchant.rest;

import com.nab.hackathon.services.merchant.entity.Merchant;
import com.nab.hackathon.services.merchant.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/merchant")
public class MerchantRest {

  @Autowired
  private MerchantRepository merchantRepository;

  @RequestMapping(value = "all", method = GET, produces = APPLICATION_JSON_VALUE)
  public List<Merchant> allMerchants() {
    return merchantRepository.findAll();
  }

  @RequestMapping(value = "/{merchantId}", method = GET, produces = APPLICATION_JSON_VALUE)
  public Merchant findByMerchantId(@PathParam("merchantId") Long merchantId) {
    return merchantRepository.findOne(merchantId);
  }

  @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  public Merchant create(Merchant merchant) {
    merchantRepository.save(merchant);
    return merchant;
  }

  @RequestMapping(value = "all", method = DELETE)
  public void delete(Long merchantId) {
    merchantRepository.delete(merchantId);
  }

}
