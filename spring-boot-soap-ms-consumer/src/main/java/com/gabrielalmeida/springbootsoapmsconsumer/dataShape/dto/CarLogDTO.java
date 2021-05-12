package com.gabrielalmeida.springbootsoapmsconsumer.dataShape.dto;

import feignServices.Car;
import feignServices.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarLogDTO {
    private Person person;
    private Car car;
}
