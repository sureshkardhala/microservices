package com.suresh.address_service.controller;

import com.suresh.address_service.dto.AddressDTO;
import com.suresh.address_service.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/address-api")
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

    @GetMapping("/employee/{id}")
    public ResponseEntity<AddressDTO> getAddressByEmployeeId(@PathVariable("id") Long employeeId){
        AddressDTO addressDTO = addressService.getAddressByEmployeeId(employeeId);
        return  ResponseEntity.ok().body(addressDTO);
    }

}
