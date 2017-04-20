package com.nab.hackathon.services.merchant.entity;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class BeaconProduct {

  @Embeddable
  class BeaconProductId implements Serializable {

    private Long productId;

    private Long beaconId;

    public BeaconProductId() {
    }

    public Long getProductId() {
      return productId;
    }

    public void setProductId(Long productId) {
      this.productId = productId;
    }

    public Long getBeaconId() {
      return beaconId;
    }

    public void setBeaconId(Long beaconId) {
      this.beaconId = beaconId;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      BeaconProductId that = (BeaconProductId) o;

      if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
      return beaconId != null ? beaconId.equals(that.beaconId) : that.beaconId == null;
    }

    @Override
    public int hashCode() {
      int result = productId != null ? productId.hashCode() : 0;
      result = 31 * result + (beaconId != null ? beaconId.hashCode() : 0);
      return result;
    }

    @Override
    public String toString() {
      return "BeaconProductId{" +
          "productId=" + productId +
          ", beaconId=" + beaconId +
          '}';
    }
  }

  @EmbeddedId
  private BeaconProductId beaconProductId;

  public BeaconProductId getBeaconProductId() {
    return beaconProductId;
  }

  public void setBeaconProductId(BeaconProductId beaconProductId) {
    this.beaconProductId = beaconProductId;
  }

  @Override
  public String toString() {
    return "BeaconProduct{" +
        "beaconProductId=" + beaconProductId +
        '}';
  }
}
