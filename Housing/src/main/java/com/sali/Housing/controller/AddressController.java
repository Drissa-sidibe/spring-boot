package com.sali.Housing.controller;

import com.sali.Housing.entity.Address;
import com.sali.Housing.service.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressServiceImpl addressService;

    @GetMapping
    public List<Address> getAddress(){
        return addressService.getAddresses();
    }
    @GetMapping("/un/{addressId}")
    public Address findAddressById(@PathVariable("addressId") long addreesId){
        return addressService.findAddressById(addreesId);
    }

    @PostMapping
    private Address createAddress(@RequestBody Address address){
       return addressService.createAddress(address);
    }

    @PutMapping("/un/{id}")
    private Address updateAddress(@PathVariable("id") Long id, @RequestBody Address address){
return addressService.updateAddress(id,address);
    }
    @DeleteMapping("{addressId}")
    public void deleteAddress(@PathVariable("addressId") Address addressId){
        addressService.deleteAddress(addressId);

    }
//    @GetMapping("/door/{doorNumber}")
//    public Address fetchAddressByDoorNumber(@PathVariable("doorNumber") String doorNumber){
//    return addressService.fetchAddressByDoorNumber(doorNumber);
//    }
}
