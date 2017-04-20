package com.nab.hackathon.services.beacon.rest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/beacon")
public class BeaconRest
{
    private static Log logger = LogFactory.getLog(BeaconRest.class);

    @Autowired
    private com.nab.hackathon.services.beacon.repository.MerchantRepository merchantRepository;

    @RequestMapping(value = "/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<com.nab.hackathon.services.beacon.entity.Merchant> allBeacons()
    {
        logger.info("Invoking /beacon/all RESTful method");
        return merchantRepository.findAll();
    }
}
