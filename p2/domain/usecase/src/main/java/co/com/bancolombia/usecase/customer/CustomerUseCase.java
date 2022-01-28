package co.com.bancolombia.usecase.customer;

import co.com.bancolombia.model.customer.Customer;
import co.com.bancolombia.model.customer.gateways.CustomerService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CustomerUseCase {
    private final CustomerService customerService;

    public Mono<Customer> getCustomer (String name) {
        return customerService.getCustomer(name);
    }

    public Mono<Customer> getLongName (String name, String surName) {
        return customerService.getLongName(name,surName);
    }

    public String getPing(String name) {
        return "Hola " + name;
    }
}
