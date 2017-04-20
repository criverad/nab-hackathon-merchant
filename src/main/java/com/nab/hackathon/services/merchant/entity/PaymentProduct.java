package com.nab.hackathon.services.merchant.entity;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class PaymentProduct {

  @Embeddable
  class PaymentProductId implements Serializable {
    private Long paymentId;
    private Long productId;

    public Long getPaymentId() {
      return paymentId;
    }

    public void setPaymentId(Long paymentId) {
      this.paymentId = paymentId;
    }

    public Long getProductId() {
      return productId;
    }

    public void setProductId(Long productId) {
      this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      PaymentProductId that = (PaymentProductId) o;

      if (paymentId != null ? !paymentId.equals(that.paymentId) : that.paymentId != null) return false;
      return productId != null ? productId.equals(that.productId) : that.productId == null;
    }

    @Override
    public int hashCode() {
      int result = paymentId != null ? paymentId.hashCode() : 0;
      result = 31 * result + (productId != null ? productId.hashCode() : 0);
      return result;
    }

    @Override
    public String toString() {
      return "PaymentProductId{" +
          "paymentId=" + paymentId +
          ", productId=" + productId +
          '}';
    }
  }

  @EmbeddedId
  private PaymentProductId paymentProductId;

  public PaymentProductId getPaymentProductId() {
    return paymentProductId;
  }

  public void setPaymentProductId(PaymentProductId paymentProductId) {
    this.paymentProductId = paymentProductId;
  }

  @Override
  public String toString() {
    return "PaymentProduct{" +
        "paymentProductId=" + paymentProductId +
        '}';
  }
}
