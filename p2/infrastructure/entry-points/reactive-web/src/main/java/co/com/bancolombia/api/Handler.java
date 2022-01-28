package co.com.bancolombia.api;

import co.com.bancolombia.model.customer.Customer;
import co.com.bancolombia.model.customer.gateways.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    //private  final UseCase useCase;
    //private  final UseCase2 useCase2;
    private final CustomerService useCase;

    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        // usecase.logic();
        String name = serverRequest.pathVariable("name");
        Mono<Customer> mono= useCase.getCustomer(name);
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(mono,Customer.class);
    }

    public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        String name = serverRequest.pathVariable("name");
        String surName = serverRequest.pathVariable("surName");
        Mono<Customer> mono= useCase.getLongName(name, surName);
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(mono,Customer.class);
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        // usecase.logic();
        return serverRequest.bodyToMono(Customer.class)
                .flatMap(cc -> Mono.just(useCase.getLongName(cc.getName(), cc.getSurName())))
                .flatMap(dd -> ServerResponse
                                .ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(Mono.just(dd),Customer.class));  // Java 1.8 Programacionj Funcional
    }
}
