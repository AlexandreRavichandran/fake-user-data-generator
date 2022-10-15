package com.fakeuserdatagenerator.fakeuserdatagenerator.service.userdata.general;

import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserGeneralData;
import com.fakeuserdatagenerator.fakeuserdatagenerator.utils.UserPictureUrlGenerator;
import com.fakeuserdatagenerator.fakeuserdatagenerator.utils.general.RandomDateGenerator;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import static java.util.Objects.isNull;

@Service
public class UserGeneralDataGeneratorServiceImpl implements UserGeneralDataGeneratorService {

    @Autowired
    private UserPictureUrlGenerator userPictureUrlGenerator;

    @Autowired
    private RandomDateGenerator randomDateGenerator;

    public UserGeneralData generateGeneralData(Faker faker, String country, String sex) {

        UserGeneralData generalData = new UserGeneralData();
        generalData.setFirstName(faker.name().firstName());
        generalData.setLastName(faker.name().lastName());
        generalData.setGender(sex);
        generalData.setAddress(faker.address().streetAddress());
        generalData.setBirthDate(this.randomDateGenerator.getRandomPastDate("dd/MM/yyyy"));
        generalData.setAge(this.calculateAgeByBirthDate(generalData.getBirthDate()));
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

    private Integer calculateAgeByBirthDate(String date){
        Calendar birthDate = new GregorianCalendar();
        Calendar today = new GregorianCalendar();
        birthDate.setTime(new Date(date));
        today.setTime(new Date());

        return (today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR));
    }
}
