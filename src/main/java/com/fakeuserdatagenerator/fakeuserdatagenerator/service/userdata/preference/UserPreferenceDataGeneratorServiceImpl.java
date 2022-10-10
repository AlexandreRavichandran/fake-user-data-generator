package com.fakeuserdatagenerator.fakeuserdatagenerator.service.userdata.preference;

import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserPreferenceData;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

@Service
public class UserPreferenceDataGeneratorServiceImpl implements UserPreferenceDataGeneratorService {

    public UserPreferenceData generatePreferenceData(Faker faker) {
        UserPreferenceData preferenceData = new UserPreferenceData();
        preferenceData.setFavoriteBook(faker.book().title());
        preferenceData.setFavoriteFood(faker.demographic().demonym() + " food");
        preferenceData.setFavoriteMovie(faker.music().chord());
        return preferenceData;
    }

}
