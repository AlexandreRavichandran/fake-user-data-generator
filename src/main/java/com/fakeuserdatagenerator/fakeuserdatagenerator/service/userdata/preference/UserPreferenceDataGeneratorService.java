package com.fakeuserdatagenerator.fakeuserdatagenerator.service.userdata.preference;

import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserPreferenceData;
import com.github.javafaker.Faker;

public interface UserPreferenceDataGeneratorService {

    UserPreferenceData generatePreferenceData(Faker faker);

}
