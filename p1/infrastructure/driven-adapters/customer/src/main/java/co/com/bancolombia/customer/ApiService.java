package co.com.bancolombia.customer;

import co.com.bancolombia.model.customer.Customer;
import co.com.bancolombia.model.customer.gateways.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiService implements CustomerRepository {

    private static final List<Customer> lista = new ArrayList<>(); // 10

    @Override
    public Customer getCustomer(String name) {
        // Memoria
        return Customer.builder().surName("Iturbide").name(name).build();
    }

    @Override
    public Customer getLongName(String name, String surName) {
        return Customer.builder().surName(surName).name(name).build();
    }

    @Override
    public String ping(String name) {
        return "Hola " + name + "!!!";
    }

    @Override
    public boolean addCustomer(String name, String surName) {
        Customer customer = Customer.builder().surName(surName).name(name).build();
        return lista.add(customer);
    }
}
