package co.com.bancolombia.model.customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   // Anotaciones  vs.  Decoradores
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Customer {   // TopLevel  & Outer
    private String name;
    private String surName;

}
