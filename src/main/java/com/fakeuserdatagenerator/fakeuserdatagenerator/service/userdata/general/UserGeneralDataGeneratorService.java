package com.fakeuserdatagenerator.fakeuserdatagenerator.service.userdata.general;

import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserGeneralData;
import com.github.javafaker.Faker;

public interface UserGeneralDataGeneratorService {

    UserGeneralData generateGeneralData(Faker faker, String country, String sex);
}
