package com.saraya.service;

import com.saraya.dao.CustomerDao;

import com.saraya.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> loadALlCustomers() throws InterruptedException {
        Long start = System.currentTimeMillis();
        List<Customer> customers = customerDao.getCustomers();
        Long end = System.currentTimeMillis();
        System.out.println("The Total execution time: " + (end - start));
return customers;
    }
    public Flux<Customer> getCustomersStream() throws InterruptedException {
        Long start = System.currentTimeMillis();
        Flux<Customer> customers = customerDao.getCustomersStream();
        Long end = System.currentTimeMillis();
        System.out.println("The Total execution time: " + (end - start));
        return customers;
    }
}
