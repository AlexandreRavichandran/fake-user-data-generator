package com.fakeuserdatagenerator.fakeuserdatagenerator.service.userdata.physical;

import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.BloodType;
import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserPhysicalData;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

@Service
public class UserPhysicalDataGeneratorServiceImpl implements UserPhysicalDataGeneratorService{

    public UserPhysicalData generatePhysicalData(Faker faker) {
        UserPhysicalData physicalData = new UserPhysicalData();
        physicalData.setHeight("1m" + faker.number().numberBetween(50, 99));
        physicalData.setWeight(faker.number().numberBetween(50, 200) + " kg");
        physicalData.setBloodType(BloodType.getRandomValue());
        return physicalData;
    }

}
