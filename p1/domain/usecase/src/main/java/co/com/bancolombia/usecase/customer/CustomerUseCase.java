package co.com.bancolombia.usecase.customer;

import co.com.bancolombia.model.customer.Customer;
import co.com.bancolombia.model.customer.gateways.CustomerRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerUseCase {
    // final constantes
    private final CustomerRepository service;

    public Customer getCustomer (String name) {
        return service.getCustomer(name);  // Modelo delegación
    }

    public Customer getLongName (String name, String surName) {
        return service.getLongName(name,surName);
    }

    public String ping (String name) {
        return service.ping(name);
    }

    public boolean addCustomer (String name, String surName) {
        return service.addCustomer(name, surName);
    }
}
