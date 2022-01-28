package co.com.bancolombia.config;

import co.com.bancolombia.model.customer.gateways.CustomerRepository;
import co.com.bancolombia.usecase.customer.CustomerUseCase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "co.com.bancolombia.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class UseCasesConfig {
        /*
        public CustomerUseCase getCustomerUseCase(CustomerRepository service) {
                return new CustomerUseCase(service);
        }
        */

}
