package com.suresh.address_service.service;

import com.suresh.address_service.dto.AddressDTO;
import com.suresh.address_service.entity.Address;
import com.suresh.address_service.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ModelMapper modelMapper;


    public AddressDTO getAddressById(Long id) {
        Address address = addressRepository.findById(id).get();
        return  modelMapper.map(address, AddressDTO.class);
    }
}
