package com.sali.Housing.entity;

import javax.persistence.*;
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue( strategy = GenerationType.TABLE)
    @Column(name = "id")
    private long addressId;
    private String doorNumber;
    private String location;
    private String street;
    private String serviceNumber;

    @OneToOne(mappedBy = "address")
    private House house;
    public Address() {
    }

    public Address(long addressId, String doorNumber, String location, String street, String serviceNumber) {
        this.addressId = addressId;
        this.doorNumber = doorNumber;
        this.location = location;
        this.street = street;
        this.serviceNumber = serviceNumber;
    }

    public House getHouse() {
        return house;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", doorNumber='" + doorNumber + '\'' +
                ", location='" + location + '\'' +
                ", street='" + street + '\'' +
                ", serviceNumber='" + serviceNumber + '\'' +
                ", house=" + house +
               '}';
    }
}
