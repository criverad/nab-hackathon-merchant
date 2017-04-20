package com.nab.hackathon.services.beacon.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Merchant
{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long beaconId;

    private String beaconName;
    private Long merchantId;

    public Merchant()
    {
    }

    public Merchant(String beaconName, Long merchantId) {
        this.beaconName = beaconName;
        this.merchantId = merchantId;
    }

    public Long getBeaconId() {
        return beaconId;
    }

    public void setBeaconId(Long beaconId) {
        this.beaconId = beaconId;
    }

    public String getBeaconName() {
        return beaconName;
    }

    public void setBeaconName(String beaconName) {
        this.beaconName = beaconName;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "beaconId=" + beaconId +
                ", beaconName='" + beaconName + '\'' +
                ", merchantId=" + merchantId +
                '}';
    }
}
