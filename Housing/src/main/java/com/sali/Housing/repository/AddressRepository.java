package com.sali.Housing.repository;

import com.sali.Housing.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

     //Address findByDoorNumber(String doorNumber);
}
