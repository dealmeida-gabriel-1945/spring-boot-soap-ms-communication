package com.gabrielalmeida.springbootsoapmsperson.web.endpoints;

import com.gabrielalmeida.springbootsoapmsperson.service.PersonService;
import generating_people.GeneratePersonRequest;
import generating_people.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PersonEndpoints {
    @Autowired
    private PersonService service;
    private static final String NAMESPACE = "generating_people";

    @PayloadRoot(namespace = NAMESPACE, localPart = "GeneratePersonRequest")
    @ResponsePayload
    public Person generatePersonRequest(@RequestPayload GeneratePersonRequest request) {
        return service.generatePerson(request);
    }
}
