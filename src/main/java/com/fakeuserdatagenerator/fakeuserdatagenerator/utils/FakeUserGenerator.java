package com.fakeuserdatagenerator.fakeuserdatagenerator.utils;

import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.BloodType;
import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.Country;
import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.Gender;
import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.PaymentType;
import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserData;
import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserGeneralData;
import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserPhysicalData;
import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserPreferenceData;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;

import static java.util.Objects.nonNull;

@Component
public class FakeUserGenerator {

    @Autowired
    CreditCardGenerator creditCardGenerator;

    public UserData generateFakeUserByNecessaryDatas(UserData userData, String country){

        if(nonNull(userData.getGeneralData())){
            userData.setGeneralData(this.generateGeneralData(country));
        }
        if (nonNull(userData.getPhysicalData())){
            userData.setPhysicalData(this.generatePhysicalData());
        }

        if(nonNull(userData.getCreditCard())){
            userData.setCreditCard(this.creditCardGenerator.generate(PaymentType.getRandom().name()));
        }

        if(nonNull(userData.getPreference())){
            userData.setPreference(this.generatePreferenceData());
        }

        return userData;
    }
    private UserGeneralData generateGeneralData(String country){
        if(nonNull(country) && nonNull(Country.getByCode(country))){
            UserGeneralData generalData = new UserGeneralData();
            Faker faker = new Faker(Locale.forLanguageTag(country));
            generalData.setFirstName(faker.name().firstName());
            generalData.setLastName(faker.name().lastName());
            generalData.setGender(Gender.getRandomValue());
            generalData.setAddress(faker.address().fullAddress());
            generalData.setAge(faker.number().numberBetween(18,80));
            generalData.setBirthDate(faker.date().birthday());
            generalData.setCountry(faker.address().country());
            generalData.setEmail(faker.internet().emailAddress());
            generalData.setPhoneNumber(faker.phoneNumber().cellPhone());
            return generalData;
         }
        return null;
    }

    private UserPhysicalData generatePhysicalData(){
        Faker faker = new Faker();
        UserPhysicalData physicalData = new UserPhysicalData();
        physicalData.setHeight("1m" + faker.number().numberBetween(50,99));
        physicalData.setWeight(String.valueOf(faker.number().numberBetween(50,200)));
        physicalData.setBloodType(BloodType.getRandomValue());
        return physicalData;
    }

    private UserPreferenceData generatePreferenceData(){
        Faker faker = new Faker();
        UserPreferenceData preferenceData = new UserPreferenceData();
        preferenceData.setFavoriteBook(faker.book().title());
        preferenceData.setFavoriteMovie(faker.music().chord());
        return preferenceData;
    }


}
