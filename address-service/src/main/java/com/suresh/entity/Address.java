package com.suresh.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="address_id")
    private Long AddressId;
    
    @Column(name = "address_dno")
    private Long AddressDoorNumber;
    
    @Column(name="address_street")
    private  String AddressStreet;
    
    @Column(name="address_city")
    private String AddressCity;
    
    @Column(name="address_pincode")
    private Long AddressPincode;

    public Address(Long addressId, Long addressDoorNumber, String addressStreet, String addressCity, Long addressPincode) {
        AddressId = addressId;
        AddressDoorNumber = addressDoorNumber;
        AddressStreet = addressStreet;
        AddressCity = addressCity;
        AddressPincode = addressPincode;
    }

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "AddressId=" + AddressId +
                ", AddressDoorNumber=" + AddressDoorNumber +
                ", AddressStreet='" + AddressStreet + '\'' +
                ", AddressCity='" + AddressCity + '\'' +
                ", AddressPincode=" + AddressPincode +
                '}';
    }

    public void setAddressId(Long addressId) {
        AddressId = addressId;
    }

    public void setAddressDoorNumber(Long addressDoorNumber) {
        AddressDoorNumber = addressDoorNumber;
    }

    public void setAddressStreet(String addressStreet) {
        AddressStreet = addressStreet;
    }

    public void setAddressCity(String addressCity) {
        AddressCity = addressCity;
    }

    public void setAddressPincode(Long addressPincode) {
        AddressPincode = addressPincode;
    }

    public Long getAddressId() {
        return AddressId;
    }

    public Long getAddressDoorNumber() {
        return AddressDoorNumber;
    }

    public String getAddressStreet() {
        return AddressStreet;
    }

    public String getAddressCity() {
        return AddressCity;
    }

    public Long getAddressPincode() {
        return AddressPincode;
    }
}
