package com.fakeuserdatagenerator.fakeuserdatagenerator.service.userdata.physical;

import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserPhysicalData;
import com.fakeuserdatagenerator.fakeuserdatagenerator.utils.general.RandomDataGenerator;
public interface UserPhysicalDataGeneratorService {

    UserPhysicalData generatePhysicalData(RandomDataGenerator randomDataGenerator);

}
