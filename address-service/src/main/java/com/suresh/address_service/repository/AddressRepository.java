package com.suresh.address_service.repository;

import com.suresh.address_service.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query(nativeQuery = true, value = "select address_id, address_city, address_pincode from address where employee_id= :employeeId")
    Address findByEmployeeId(@Param("employeeId") Long employeeId);
}
