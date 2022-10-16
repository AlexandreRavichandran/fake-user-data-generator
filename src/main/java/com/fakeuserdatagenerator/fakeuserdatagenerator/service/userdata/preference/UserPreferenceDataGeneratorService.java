package com.fakeuserdatagenerator.fakeuserdatagenerator.service.userdata.preference;

import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserPreferenceData;
import com.fakeuserdatagenerator.fakeuserdatagenerator.utils.general.RandomDataGenerator;

public interface UserPreferenceDataGeneratorService {

    UserPreferenceData generatePreferenceData(RandomDataGenerator randomDataGenerator);

}
