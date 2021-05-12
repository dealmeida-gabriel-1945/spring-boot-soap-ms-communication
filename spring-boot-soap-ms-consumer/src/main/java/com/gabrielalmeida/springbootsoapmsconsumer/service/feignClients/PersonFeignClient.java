package com.gabrielalmeida.springbootsoapmsconsumer.service.feignClients;

import feignServices.GeneratePersonRequest;
import feignServices.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class PersonFeignClient {
    @Autowired
    private Jaxb2Marshaller marshaller;

    private WebServiceTemplate template;

    public Person getPerson(GeneratePersonRequest request){
        template = new WebServiceTemplate(marshaller);
        return ((Person) template.marshalSendAndReceive(
                "http://localhost:8090/ws",
                request
        ));
    }
}
