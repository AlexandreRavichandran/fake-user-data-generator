package com.fakeuserdatagenerator.fakeuserdatagenerator.service.userdata.general;

import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserGeneralData;
import com.fakeuserdatagenerator.fakeuserdatagenerator.utils.UserPictureUrlGenerator;
import com.fakeuserdatagenerator.fakeuserdatagenerator.utils.general.RandomDataGenerator;
import com.fakeuserdatagenerator.fakeuserdatagenerator.utils.general.RandomDateGenerator;
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

    public UserGeneralData generateGeneralData(RandomDataGenerator randomDataGenerator, String country, String sex) {

        UserGeneralData generalData = new UserGeneralData();
        generalData.setFirstName(randomDataGenerator.getFirstName());
        generalData.setLastName(randomDataGenerator.getLastName());
        generalData.setGender(sex);
        generalData.setAddress(randomDataGenerator.getAddress());
        generalData.setBirthDate(this.randomDateGenerator.getRandomPastDate("dd/MM/yyyy"));
        generalData.setAge(this.calculateAgeByBirthDate(generalData.getBirthDate()));
        if (isNull(country)) {
            String countryCode = randomDataGenerator.getCountryCode();
            Locale i = new Locale(countryCode);
            generalData.setCountry(i.getDisplayCountry());
            generalData.setCountryCode(countryCode);
        } else {
            generalData.setCountry(country);
            generalData.setCountryCode(country.toUpperCase());
        }

        generalData.setEmail(randomDataGenerator.getEmail());
        generalData.setPhoneNumber(randomDataGenerator.getPhoneNumber());
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
