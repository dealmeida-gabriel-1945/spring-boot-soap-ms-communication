package com.gabrielalmeida.springbootsoapmsperson.service;

import generating_people.GeneratePersonRequest;
import generating_people.Person;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PersonService {

    private final String[] MALE_NAMES = {"ADAM", "BUCK", "GABRIEL", "JAMES"};
    private final String[] FEMALE_NAMES = {"JESSICA", "GABRIELLA", "JOANA", "TRISHA"};
    private final String[] LAST_NAMES = {"BROWN", "DEMARCO", "HEISENBERG", "ADAMS"};
    private final Integer ARRAYS_SIZE = 4;

    public Person generatePerson(GeneratePersonRequest request) {
        Random rand = new Random();
        Person toReturn = new Person();

        toReturn.setName(getNamesArray(request.isPersonSex())[rand.nextInt(ARRAYS_SIZE)]);
        toReturn.setLastName(LAST_NAMES[rand.nextInt(ARRAYS_SIZE)]);
        toReturn.setAge(rand.nextInt(120));
        toReturn.setSex(request.isPersonSex() ? "FEMALE" : "MALE");

        return toReturn;
    }

    private String[] getNamesArray(Boolean sex){
        return sex ? this.FEMALE_NAMES : this.MALE_NAMES;
    }
}
