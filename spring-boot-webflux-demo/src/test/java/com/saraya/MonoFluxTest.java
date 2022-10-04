package com.saraya;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono() {


        Mono<?> monoString = Mono.just("DrissaB")
                .then(Mono.error(new RuntimeException("Exception occured")))
                .log();
        //subscriber calls the subscribe() method of publisher
        monoString.subscribe(System.out::println, (e) -> System.out.println(e.getMessage()));
    }
    @Test
    public void testFlux(){
        Flux<String> fluxString = Flux.just("Spring","Boooot", "hibernate")
                .concatWithValues("AWS")
                .log();
        fluxString.subscribe(System.out::println);

    }
}
