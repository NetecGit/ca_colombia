package co.com.bancolombia.model.customer.gateways;

import co.com.bancolombia.model.customer.Customer;

public abstract interface CustomerRepository {
    Customer getCustomer(String name);
    public abstract Customer getLongName(String name, String surName);
    String ping (String name);
    boolean addCustomer(String name, String surName);
}
