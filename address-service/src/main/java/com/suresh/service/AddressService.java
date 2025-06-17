package com.suresh.service;

import com.suresh.entity.Address;
import com.suresh.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address getAddressById(Long Id) {
        return addressRepository.findByAddressId(Id);
    }
}
