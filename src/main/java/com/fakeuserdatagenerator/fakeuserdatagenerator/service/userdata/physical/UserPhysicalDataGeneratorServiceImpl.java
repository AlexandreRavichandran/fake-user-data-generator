package com.fakeuserdatagenerator.fakeuserdatagenerator.service.userdata.physical;

import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.BloodType;
import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserPhysicalData;
import com.fakeuserdatagenerator.fakeuserdatagenerator.utils.general.RandomDataGenerator;
import org.springframework.stereotype.Service;

@Service
public class UserPhysicalDataGeneratorServiceImpl implements UserPhysicalDataGeneratorService{

    public UserPhysicalData generatePhysicalData(RandomDataGenerator randomDataGenerator) {
        UserPhysicalData physicalData = new UserPhysicalData();
        physicalData.setHeight("1m" + randomDataGenerator.getRandomNumberBetween(50, 99));
        physicalData.setWeight(randomDataGenerator.getRandomNumberBetween(50,200) + " kg");
        physicalData.setBloodType(BloodType.getRandomValue());
        return physicalData;
    }

}
