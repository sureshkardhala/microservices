package com.suresh.employee_service.feignclient;

import com.suresh.employee_service.dto.AddressDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "myFeignclient", url = "http://localhost:8081/address-api")
public interface AddressFeignClient { //Looks like proxy
    @GetMapping("/employee/{id}")
    public ResponseEntity<AddressDTO> getAddressByEmployeeId(@PathVariable("id") Long employeeId);
}
