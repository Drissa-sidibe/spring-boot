package com.saraya.controller.handler;

import com.saraya.dao.CustomerDao;
import com.saraya.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerStreamHandler {
    @Autowired
    private CustomerDao dao;
    public Mono<ServerResponse> getCustomersTream(ServerRequest request) {
        Flux<Customer> customerStream = null;
        try {
            customerStream = dao.getCustomersStream();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ServerResponse.ok().body(customerStream, Customer.class);
    }
}
