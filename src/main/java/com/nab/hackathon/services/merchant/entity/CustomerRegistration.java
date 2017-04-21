package com.nab.hackathon.services.merchant.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

import static com.nab.hackathon.services.merchant.Constants.JSON_UTC_DATE_FORMAT;

@Entity
public class CustomerRegistration {

  @Embeddable
  class CustomerRegistrationId implements Serializable {

    private String beaconId;

    private Long customerId;

    public CustomerRegistrationId() {
    }

    public String getBeaconId() {
      return beaconId;
    }

    public void setBeaconId(String beaconId) {
      this.beaconId = beaconId;
    }

    public Long getCustomerId() {
      return customerId;
    }

    public void setCustomerId(Long customerId) {
      this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      CustomerRegistrationId that = (CustomerRegistrationId) o;

      if (beaconId != null ? !beaconId.equals(that.beaconId) : that.beaconId != null) return false;
      return customerId != null ? customerId.equals(that.customerId) : that.customerId == null;
    }

    @Override
    public int hashCode() {
      int result = beaconId != null ? beaconId.hashCode() : 0;
      result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
      return result;
    }

    @Override
    public String toString() {
      return "CustomerRegistrationId{" +
          "beaconId=" + beaconId +
          ", customerId=" + customerId +
          '}';
    }
  }

  @EmbeddedId
  private CustomerRegistrationId customerRegistrationId;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JSON_UTC_DATE_FORMAT)
  @Temporal(TemporalType.TIMESTAMP)
  private Date checkIn;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JSON_UTC_DATE_FORMAT)
  @Temporal(TemporalType.TIMESTAMP)
  private Date checkOut;

  public CustomerRegistrationId getCustomerRegistrationId() {
    return customerRegistrationId;
  }

  public void setCustomerRegistrationId(CustomerRegistrationId customerRegistrationId) {
    this.customerRegistrationId = customerRegistrationId;
  }

  public Date getCheckIn() {
    return checkIn;
  }

  public void setCheckIn(Date checkIn) {
    this.checkIn = checkIn;
  }

  public Date getCheckOut() {
    return checkOut;
  }

  public void setCheckOut(Date checkOut) {
    this.checkOut = checkOut;
  }

  @Override
  public String toString() {
    return "CustomerRegistration{" +
        "customerRegistrationId=" + customerRegistrationId +
        ", checkIn=" + checkIn +
        ", checkOut=" + checkOut +
        '}';
  }
}
