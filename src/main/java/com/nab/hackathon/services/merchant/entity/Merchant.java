package com.nab.hackathon.services.merchant.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Merchant {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long merchantId;

  private String name;

  private String logo;

  public Merchant() {
  }

  public Long getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(Long merchantId) {
    this.merchantId = merchantId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLogo() {
    return logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }

  @Override
  public String toString() {
    return "Merchant{" +
        "merchantId=" + merchantId +
        ", name='" + name + '\'' +
        ", logo='" + logo + '\'' +
        '}';
  }
}
