package com.nab.hackathon.services.merchant.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long paymentId;

  private Double amount;

  private String description;

  @Temporal(TemporalType.TIMESTAMP)
  private Date date;

  private String outcome;

  private Long beaconId;

  private Long customerId;

  private Long merchantId;

  public Long getPaymentId() {
    return paymentId;
  }

  public void setPaymentId(Long paymentId) {
    this.paymentId = paymentId;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getOutcome() {
    return outcome;
  }

  public void setOutcome(String outcome) {
    this.outcome = outcome;
  }

  public Long getBeaconId() {
    return beaconId;
  }

  public void setBeaconId(Long beaconId) {
    this.beaconId = beaconId;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public Long getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(Long merchantId) {
    this.merchantId = merchantId;
  }

  @Override
  public String toString() {
    return "Payment{" +
        "paymentId=" + paymentId +
        ", amount=" + amount +
        ", description='" + description + '\'' +
        ", date=" + date +
        ", outcome='" + outcome + '\'' +
        ", beaconId=" + beaconId +
        ", customerId=" + customerId +
        ", merchantId=" + merchantId +
        '}';
  }
}
