package co.com.bancolombia.model.customer.gateways;
import co.com.bancolombia.model.customer.Customer;
import reactor.core.publisher.Mono;

public interface CustomerService {
    Mono<Customer>  getCustomer(String name);
    Mono<Customer>  getLongName(String name, String surName);
}
