package com.sali.Housing.service;

import com.sali.Housing.entity.Address;
import com.sali.Housing.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressServiceInter{


    @Autowired
    private AddressRepository addressRepository;
    @Override
    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address findAddressById(Long addressId) {
        return addressRepository.findById(addressId).get();
    }

    @Override
    public Address updateAddress(Long id, Address address) {

        Address address1 = addressRepository.findById(id).get();

       if(Objects.nonNull(address.getDoorNumber()) && !"".equalsIgnoreCase(address.getDoorNumber())){
           address1.setDoorNumber(address.getDoorNumber());
       }
        if(Objects.nonNull(address.getServiceNumber()) && !"".equalsIgnoreCase(address.getServiceNumber())){
            address1.setServiceNumber(address.getServiceNumber());
        }
        if(Objects.nonNull(address.getLocation()) && !"".equalsIgnoreCase(address.getLocation())){
            address1.setLocation(address.getLocation());
        }
      return addressRepository.save(address1);

    }

    @Override
    public void deleteAddress(Address addressId) {
        addressRepository.delete(addressId);
    }

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);

    }

}
