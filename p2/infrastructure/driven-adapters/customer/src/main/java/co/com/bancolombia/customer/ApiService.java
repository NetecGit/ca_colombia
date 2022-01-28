package co.com.bancolombia.customer;

import co.com.bancolombia.model.customer.Customer;
import co.com.bancolombia.model.customer.gateways.CustomerService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ApiService implements CustomerService {

    @Override
    public Mono<Customer> getCustomer(String name) {
        return Mono.just(Customer.builder().name(name).build());
    }

    @Override
    public Mono<Customer> getLongName(String name, String surName) {
        return Mono.just(
                Customer.builder()
                        .surName(surName)
                        .name(name)
                        .build());
    }
}
