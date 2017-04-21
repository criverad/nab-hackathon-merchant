package com.nab.hackathon.services.merchant.client;

public class NotificationRequest {

  private String target;
  private String message;
  private String subject;

  public NotificationRequest() {
  }

  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  @Override
  public String toString() {
    return "NotificationRequest{" +
        "target='" + target + '\'' +
        ", message='" + message + '\'' +
        ", subject='" + subject + '\'' +
        '}';
  }
}
