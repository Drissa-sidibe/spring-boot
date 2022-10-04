package com.saraya.dao;


import com.saraya.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
@Component
public class CustomerDao {

    private static void sleepExec(int i) {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public List<Customer> getCustomers() throws InterruptedException{
      return   IntStream.range(1, 10)
              .peek(CustomerDao::sleepExec)
              .peek(i -> System.out.println("Processing count"))
                .mapToObj(i ->
                        new Customer(i, "customer" + i ))
              .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomersStream() throws InterruptedException{
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i->System.out.println("processing count: " + i))
                .map(i -> new Customer(i, "Customer"));

    }
    public Flux<Customer> getCustomer(){
        return Flux.range(1,50)
                .doOnNext( i -> System.out.println("Processing Count: " + i))
                .map(i -> new Customer(i, "Customer"));
    }
}
