package com.gabrielalmeida.springbootsoapmsconsumer.service;

import com.gabrielalmeida.springbootsoapmsconsumer.dataShape.dto.CarLogDTO;
import com.gabrielalmeida.springbootsoapmsconsumer.dataShape.dto.LogRequestDTO;
import com.gabrielalmeida.springbootsoapmsconsumer.service.feignClients.CarFeignClient;
import com.gabrielalmeida.springbootsoapmsconsumer.service.feignClients.PersonFeignClient;
import feignServices.GenerateCarRequest;
import feignServices.GeneratePersonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    @Autowired
    private CarFeignClient carFeignClient;
    @Autowired
    private PersonFeignClient personFeignClient;
    public CarLogDTO generate(LogRequestDTO request) {
        GeneratePersonRequest generatePersonRequest = new GeneratePersonRequest();
        generatePersonRequest.setPersonSex(request.isPersonSex());

        GenerateCarRequest generateCarRequest = new GenerateCarRequest();
        generateCarRequest.setPlateNumber(request.getPlateNumber());
        generateCarRequest.setYearOfConstruction(request.getYearOfConstruction());

        return new CarLogDTO(
            personFeignClient.getPerson(generatePersonRequest),
            carFeignClient.getCar(generateCarRequest)
        );
    }
}
