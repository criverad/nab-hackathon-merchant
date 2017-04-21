package com.nab.hackathon.services.merchant.rest;

import com.nab.hackathon.services.merchant.client.NotificationServiceClient;
import com.nab.hackathon.services.merchant.entity.Payment;
import com.nab.hackathon.services.merchant.repository.PaymentRepository;
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
@RequestMapping(value = "/payment")
public class PaymentRest {

  @Autowired
  private PaymentRepository paymentRepository;

  @Autowired
  private NotificationServiceClient notificationServiceClient;

  @RequestMapping(value = "all", method = GET, produces = APPLICATION_JSON_VALUE)
  public List<Payment> all() {
    return paymentRepository.findAll();
  }

  @RequestMapping(value = "/{paymentId}", method = GET, produces = APPLICATION_JSON_VALUE)
  public Payment findByPaymentId(@PathVariable("paymentId") Long paymentId) {
    return paymentRepository.findOne(paymentId);
  }

  @RequestMapping(value = "/beacon/{beaconId}", method = GET, produces = APPLICATION_JSON_VALUE)
  public List<Payment> findByBeaconId(@PathVariable("beaconId") String beaconId) {
    return paymentRepository.findByBeaconId(beaconId);
  }

  @RequestMapping(value = "/merchant/{merchantId}", method = GET, produces = APPLICATION_JSON_VALUE)
  public List<Payment> findByMerchantId(@PathVariable("merchantId") Long merchantId) {
    return paymentRepository.findByMerchantId(merchantId);
  }

  @RequestMapping(value = "/customer/{customerId}", method = GET, produces = APPLICATION_JSON_VALUE)
  public List<Payment> findByCustomerId(@PathVariable("customerId") Long customerId) {
    return paymentRepository.findByCustomerId(customerId);
  }

  @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  public Payment create(@RequestBody Payment payment) {
    boolean isPaymentRequest = payment.getPaymentId() != null && payment.getPaymentId() >= 1L;

    Payment savedPayment = paymentRepository.save(payment);

    if (isPaymentRequest) {
      notificationServiceClient.sendPaymentNotificationToMerchant(payment);
    } else {
      notificationServiceClient.sendPaymentNotificationToUser(payment);
    }

    return savedPayment;
  }

  @RequestMapping(value = "/{paymentId}", method = DELETE)
  public void delete(@PathVariable("paymentId") Long paymentId) {
    paymentRepository.delete(paymentId);
  }

}
