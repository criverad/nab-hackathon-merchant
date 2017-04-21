package com.nab.hackathon.services.merchant.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NotificationServiceClient {

  @Value("${services.notificationService.baseUri}")
  private String baseUri;

  @Value("${services.notificationService.notifyPath}")
  private String notifyPath;

  public void sendNotification(String target, String message, String subject) {
    NotificationRequest notificationRequest = new NotificationRequest();
    notificationRequest.setTarget(target);
    notificationRequest.setMessage(message);
    notificationRequest.setSubject(subject);

    RestTemplate restTemplate = new RestTemplate();
    restTemplate.postForObject(baseUri + notifyPath, notificationRequest, NotificationRequest.class);
  }


}
