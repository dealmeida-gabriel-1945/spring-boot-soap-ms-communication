package com.gabrielalmeida.springbootsoapmscar.service;

import generating_cars.Car;
import generating_cars.GenerateCarRequest;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CarService {

    private final String[] BRANDS_NAMES = {"TOYOTA", "VOLKSWAGEN", "FORD", "TESLA"};
    private final String[] COLORS_NAMES = {"BLACK", "RED", "WHITE", "BLUE"};
    private final Integer ARRAYS_SIZE = 4;

    public Car generateCar(GenerateCarRequest request) {
        Random rand = new Random();
        Car toReturn = new Car();

        toReturn.setBrand(BRANDS_NAMES[rand.nextInt(ARRAYS_SIZE)]);
        toReturn.setColor(COLORS_NAMES[rand.nextInt(ARRAYS_SIZE)]);
        toReturn.setYearOfConstruction(request.getYearOfConstruction() + "");
        toReturn.setPlateNumer(request.getPlateNumber());

        return toReturn;
    }
}
