package com.fakeuserdatagenerator.fakeuserdatagenerator.service.userdata.general;

import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserGeneralData;
import com.fakeuserdatagenerator.fakeuserdatagenerator.utils.UserPictureUrlGenerator;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

import static java.util.Objects.isNull;

@Service
public class UserGeneralDataGeneratorServiceImpl implements UserGeneralDataGeneratorService {

    @Autowired
    private UserPictureUrlGenerator userPictureUrlGenerator;

    public UserGeneralData generateGeneralData(Faker faker, String country, String sex) {

        UserGeneralData generalData = new UserGeneralData();
        generalData.setFirstName(faker.name().firstName());
        generalData.setLastName(faker.name().lastName());
        generalData.setGender(sex);
        generalData.setAddress(faker.address().streetAddress());
        generalData.setAge(faker.number().numberBetween(18, 80));
        generalData.setBirthDate(faker.date().birthday());
        if (isNull(country)) {
            String countryCode = faker.address().countryCode();
            Locale i = new Locale(countryCode);
            generalData.setCountry(i.getDisplayCountry());
            generalData.setCountryCode(countryCode);
        } else {
            generalData.setCountry(country);
            generalData.setCountryCode(country.toUpperCase());
        }

        generalData.setEmail(faker.internet().emailAddress());
        generalData.setPhoneNumber(faker.phoneNumber().cellPhone());
        generalData.setPictureUrl(this.userPictureUrlGenerator.generatePictureUrlBySexAndByAge(
                generalData.getGender(), generalData.getAge()));


        return generalData;
    }
}
