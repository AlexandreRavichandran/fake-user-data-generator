package com.fakeuserdatagenerator.fakeuserdatagenerator.service.userdata.general;

import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserGeneralData;
import com.fakeuserdatagenerator.fakeuserdatagenerator.utils.general.RandomDataGenerator;
public interface UserGeneralDataGeneratorService {

    UserGeneralData generateGeneralData(RandomDataGenerator randomDataGenerator, String country, String sex);
}
