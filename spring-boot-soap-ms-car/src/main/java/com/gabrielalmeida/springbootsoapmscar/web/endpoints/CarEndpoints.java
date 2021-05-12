package com.gabrielalmeida.springbootsoapmscar.web.endpoints;

import com.gabrielalmeida.springbootsoapmscar.service.CarService;
import generating_cars.Car;
import generating_cars.GenerateCarRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CarEndpoints {
    @Autowired
    private CarService service;
    private static final String NAMESPACE = "generating_cars";

    @PayloadRoot(namespace = NAMESPACE, localPart = "GenerateCarRequest")
    @ResponsePayload
    public Car generateCarRequest(@RequestPayload GenerateCarRequest request) {
        return service.generateCar(request);
    }
}
