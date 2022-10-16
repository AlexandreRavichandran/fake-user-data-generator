package com.fakeuserdatagenerator.fakeuserdatagenerator.service.userdata.preference;

import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserPreferenceData;
import com.fakeuserdatagenerator.fakeuserdatagenerator.utils.general.RandomDataGenerator;
import org.springframework.stereotype.Service;

@Service
public class UserPreferenceDataGeneratorServiceImpl implements UserPreferenceDataGeneratorService {

    public UserPreferenceData generatePreferenceData(RandomDataGenerator randomDataGenerator) {
        UserPreferenceData preferenceData = new UserPreferenceData();
        preferenceData.setFavoriteBook("");
        preferenceData.setFavoriteFood(randomDataGenerator.getFoodType());
        preferenceData.setFavoriteMovie("");
        return preferenceData;
    }

}
