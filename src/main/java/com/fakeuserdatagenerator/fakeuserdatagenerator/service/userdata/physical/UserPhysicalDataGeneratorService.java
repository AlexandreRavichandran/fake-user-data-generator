package com.fakeuserdatagenerator.fakeuserdatagenerator.service.userdata.physical;

import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserPhysicalData;
import com.github.javafaker.Faker;

public interface UserPhysicalDataGeneratorService {

    UserPhysicalData generatePhysicalData(Faker faker);

}
