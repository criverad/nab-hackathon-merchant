package com.nab.hackathon.services.merchant.rest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.nab.hackathon.services.merchant.repository.MerchantRepository;

@RestController
@RequestMapping(value = "/merchant")
public class MerchantRest
{
    private static Log logger = LogFactory.getLog(com.nab.hackathon.services.merchant.rest.MerchantRest.class);

    @Autowired
    private MerchantRepository merchantRepository;

    @RequestMapping(value = "/{merchantId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<com.nab.hackathon.services.merchant.entity.Merchant> getMerchant()
    {
        logger.info("Invoking /merchant/all RESTful method");
        return merchantRepository.findAll();
    }
}
