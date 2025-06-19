package com.suresh.address_service.controller;

import com.suresh.address_service.dto.AddressDTO;
import com.suresh.address_service.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;
    @GetMapping("/")
    public ResponseEntity<String> addressHome(){
      return ResponseEntity.ok().body("Welcome home")  ;
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable Long id){
        AddressDTO addressDTO = addressService.getAddressById(id);
        return  ResponseEntity.ok().body(addressDTO);
    }

}
