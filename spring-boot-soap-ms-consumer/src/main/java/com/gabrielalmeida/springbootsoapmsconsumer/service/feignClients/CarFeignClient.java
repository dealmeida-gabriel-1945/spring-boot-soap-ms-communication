package com.gabrielalmeida.springbootsoapmsconsumer.service.feignClients;

import feignServices.Car;
import feignServices.GenerateCarRequest;
import feignServices.GeneratePersonRequest;
import feignServices.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class CarFeignClient {
    @Autowired
    private Jaxb2Marshaller marshaller;

    private WebServiceTemplate template;

    public Car getCar(GenerateCarRequest request){
        template = new WebServiceTemplate(marshaller);
        return ((Car) template.marshalSendAndReceive(
                "http://localhost:8091/ws",
                request
        ));
    }
}
