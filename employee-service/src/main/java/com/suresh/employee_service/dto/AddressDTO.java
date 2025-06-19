package com.suresh.employee_service.dto;

public class AddressDTO {
    private Long addressId;
    private String addressCity;
    private Long addressPinCode;

    public AddressDTO(Long addressId, String addressCity, Long addressPinCode) {
        this.addressId = addressId;
        this.addressCity = addressCity;
        this.addressPinCode = addressPinCode;
    }

    public AddressDTO() {
    }

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
}

