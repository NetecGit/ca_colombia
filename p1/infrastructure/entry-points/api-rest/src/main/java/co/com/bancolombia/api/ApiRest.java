package co.com.bancolombia.api;
import co.com.bancolombia.model.customer.Customer;
import co.com.bancolombia.usecase.customer.CustomerUseCase;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
//    private final MyUseCase useCase;
    private final CustomerUseCase useCase;
    private final static Logger LOGGER = LoggerFactory.getLogger(ApiRest.class);

    @GetMapping(path = "/path")
    public String commandName() {
//      return useCase.doAction();
        return "Hello World";
    }

    @GetMapping(path="/ping/{name}")
    public String ping (@PathVariable String name) {
        return useCase.ping(name);
    }

    @GetMapping(path="/customer/{name}")
    public Customer getCustomer (@PathVariable String name) {
        return useCase.getCustomer(name);
    }

    @GetMapping(path="/customer/{name}/{surName}")
    public Customer getCustomer (@PathVariable String name, @PathVariable String surName) {
        return useCase.getLongName(name,surName);
    }

    // Spring MVC
    @PostMapping("/customer-add")
    public boolean putCustomer (@RequestBody Customer customer) {
        String name = customer.getName();
        String surName = customer.getSurName();
        LOGGER.info("Mensaje :::: " + name + " " + surName);
        return useCase.addCustomer(name,surName);
    }
}
