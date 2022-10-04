package com.saraya.router;

import com.saraya.controller.handler.CustomerHandler;
import com.saraya.controller.handler.CustomerStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class RouterConfig {

    @Autowired
    private CustomerHandler handler ;
    @Autowired
    private CustomerStreamHandler streamHandler;
    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions.route()
                .GET("router/customers", handler ::loadCustomerFlux)
                        .
        GET("router/customers/stream", streamHandler::getCustomersTream).build();

    }
}
