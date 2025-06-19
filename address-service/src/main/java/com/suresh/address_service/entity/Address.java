package com.suresh.address_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "address_city")
    private String addressCity;

    @Column(name = "address_pincode")
    private Long addressPinCode;


    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public Long getAddressPinCode() {
        return addressPinCode;
    }

    public void setAddressPinCode(Long addressPinCode) {
        this.addressPinCode = addressPinCode;
    }

    public Address(Long addressId, String addressCity, Long addressPinCode) {
        this.addressId = addressId;
        this.addressCity = addressCity;
        this.addressPinCode = addressPinCode;
    }

    public Address() {
    }
}
