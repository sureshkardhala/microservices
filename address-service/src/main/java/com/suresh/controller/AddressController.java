package com.suresh.controller;

import com.suresh.entity.Address;
import com.suresh.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;
    @GetMapping("/")
    public String home(){
        return "Welcome to address service";
    }

    @GetMapping("/getAddress/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id){
        Address address = addressService.getAddressById(id);
        return  ResponseEntity.ok().body(address);
    }
}
