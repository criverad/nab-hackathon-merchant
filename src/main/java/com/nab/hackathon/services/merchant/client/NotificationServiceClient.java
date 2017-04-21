package com.nab.hackathon.services.merchant.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nab.hackathon.services.merchant.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static com.nab.hackathon.services.merchant.Constants.SUBJECT_PAYMENT_CREATED;
import static com.nab.hackathon.services.merchant.Constants.SUBJECT_PAYMENT_RECEIVED;

@Component
public class NotificationServiceClient {

  @Value("${services.notificationService.baseUri}")
  private String baseUri;

  @Value("${services.notificationService.notifyPath}")
  private String notifyPath;

  @Autowired
  private ObjectMapper objectMapper;

  public void sendPaymentNotificationToMerchant(Payment payment) {
    sendNotification("/topic/merchant/" + payment.getMerchantId(), payment, SUBJECT_PAYMENT_RECEIVED);
  }

  public void sendPaymentNotificationToUser(Payment payment) {
    sendNotification("/topic/user/" + payment.getCustomerId(), payment, SUBJECT_PAYMENT_CREATED);
  }

  private void sendNotification(String target, Payment payment, String subject) {
    NotificationRequest notificationRequest = new NotificationRequest();
    notificationRequest.setTarget(target);
    notificationRequest.setMessage(toJson(payment));
    notificationRequest.setSubject(subject);

    new RestTemplate().postForObject(baseUri + notifyPath, notificationRequest, NotificationRequest.class);
  }

  private String toJson(Payment payment) {
    try {
      return objectMapper.writeValueAsString(payment);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Failed to serialize payment " + payment + " to json");
    }
  }

}
