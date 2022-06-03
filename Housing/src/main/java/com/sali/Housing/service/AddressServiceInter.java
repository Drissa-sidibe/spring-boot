package com.sali.Housing.service;

import com.sali.Housing.entity.Address;

import java.util.List;

public interface AddressServiceInter {

    List<Address> getAddresses();
    Address findAddressById(Long addressId);

    Address updateAddress(Long id, Address address);
    void  deleteAddress(Address addressId);

    Address createAddress(Address address);
   // Address fetchAddressByDoorNumber(String doorNumber);
}
