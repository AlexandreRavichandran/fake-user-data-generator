package com.fakeuserdatagenerator.fakeuserdatagenerator.utils;

import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.BloodType;
import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.Country;
import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.Gender;
import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.PaymentType;
import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.*;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Component
public class FakeUserGenerator {

    @Autowired
    CreditCardGenerator creditCardGenerator;

    @Autowired
    Faker faker;

    public UserData generateFakeUserByNecessaryDatas(UserData userData, String country) {

        if (nonNull(userData.getGeneralData())) {
            userData.setGeneralData(this.generateGeneralData(country));
        }
        if (nonNull(userData.getPhysicalData())) {
            userData.setPhysicalData(this.generatePhysicalData());
        }

        if (nonNull(userData.getCreditCard())) {
            userData.setCreditCard(this.creditCardGenerator.generate(PaymentType.getRandom().name()));
        }

        if (nonNull(userData.getPreference())) {
            userData.setPreference(this.generatePreferenceData());
        }

        if (nonNull(userData.getSocialNetwork())) {
            userData.setSocialNetwork(this.generateSocialNetwork());
        }

        return userData;
    }

    private UserSocialNetworkData generateSocialNetwork() {
        UserSocialNetworkData socialNetworkData = new UserSocialNetworkData();
        socialNetworkData.setFacebookUrl("https://www.facebook.com/" + this.faker.name().username());
        socialNetworkData.setTwitterUrl("https://twitter.com/" + this.faker.name().username());
        socialNetworkData.setInstagramUrl("https://www.instagram.com/" + this.faker.name().username());
        return socialNetworkData;
    }

    private UserGeneralData generateGeneralData(String country) {
        if (isNull(country) && nonNull(Country.getByCode(country))) {
            country = Country.getRandomValue();
        }
        UserGeneralData generalData = new UserGeneralData();
        Faker faker = new Faker(Locale.forLanguageTag(country));
        generalData.setFirstName(faker.name().firstName());
        generalData.setLastName(faker.name().lastName());
        generalData.setGender(Gender.getRandomValue());
        generalData.setAddress(faker.address().fullAddress());
        generalData.setAge(faker.number().numberBetween(18, 80));
        generalData.setBirthDate(faker.date().birthday());
        generalData.setCountry(faker.address().country());
        generalData.setEmail(faker.internet().emailAddress());
        generalData.setPhoneNumber(faker.phoneNumber().cellPhone());
        return generalData;
    }

    private UserPhysicalData generatePhysicalData() {
        UserPhysicalData physicalData = new UserPhysicalData();
        physicalData.setHeight("1m" + this.faker.number().numberBetween(50, 99));
        physicalData.setWeight(this.faker.number().numberBetween(50, 200) + " kg");
        physicalData.setBloodType(BloodType.getRandomValue());
        return physicalData;
    }

    private UserPreferenceData generatePreferenceData() {
        UserPreferenceData preferenceData = new UserPreferenceData();
        preferenceData.setFavoriteBook(this.faker.book().title());
        preferenceData.setFavoriteMovie(this.faker.music().chord());
        return preferenceData;
    }


}
