package com.nab.hackathon.services.merchant.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long productId;

  private String name;

  private String image;

  private Long merchantId;

  private Double price;

  public Product() {
  }

  public Product(String productName, Long productId) {
    this.name = productName;
    this.productId = productId;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImage() {
    return image;
  }

  public void setProductImage() {
    this.image = image;
  }

  public Long getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(Long merchantId) {
    this.merchantId = merchantId;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Product{" +
        "productId=" + productId +
        ", name='" + name + '\'' +
        ", image='" + image + '\'' +
        ", merchantId=" + merchantId +
        ", price=" + price +
        '}';
  }
}
