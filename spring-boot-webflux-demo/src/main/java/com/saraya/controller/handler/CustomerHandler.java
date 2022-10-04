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
public class CustomerHandler {

    @Autowired
    private CustomerDao customerDao;

    public Mono<ServerResponse> loadCustomerFlux(ServerRequest request) {
        Flux<Customer> customerFlux  = customerDao.getCustomer();
        return ServerResponse.ok().body(customerFlux, Customer.class);
    }
}
