package com.fakeuserdatagenerator.fakeuserdatagenerator.service;

import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.BloodType;
import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.Country;
import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.Gender;
import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.PaymentType;
import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.*;
import com.fakeuserdatagenerator.fakeuserdatagenerator.utils.UserPictureUrlGenerator;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class UserDataGeneratorServiceImpl implements UserDataGeneratorService {


    @Autowired
    CreditCardGeneratorServiceImpl creditCardGeneratorService;

    @Autowired
    UserPictureUrlGenerator userPictureUrlGenerator;

    @Autowired
    Faker faker;


    @Override
    public UserData generateFakeUserByNecessaryDatas(UserData userData, String country) {

        if (nonNull(userData.getGeneralData())) {
            userData.setGeneralData(this.generateGeneralData(country));
        }
        if (nonNull(userData.getPhysicalData())) {
            userData.setPhysicalData(this.generatePhysicalData());
        }

        if (nonNull(userData.getCreditCard())) {
            userData.setCreditCard(this.creditCardGeneratorService.generate(PaymentType.getRandom().name()));
        }

        if (nonNull(userData.getPreference())) {
            userData.setPreference(this.generatePreferenceData());
        }

        if (nonNull(userData.getSocialNetwork())) {
            userData.setSocialNetwork(this.generateSocialNetwork());
        }

        userData.setJob(this.faker.job().title());
        return userData;
    }

    @Override
    public List<UserData> generateManyFakeUserByNecessaryData(UserData userData, String country, String number) {
        List<UserData> userDataList = new ArrayList<>();

        if (Integer.parseInt(number) > 0) {
            for (int i = 0; i <= Integer.parseInt(number); i++) {
                userDataList.add(this.generateFakeUserByNecessaryDatas(userData, country));
            }
        }
        return userDataList;
    }

    private UserSocialNetworkData generateSocialNetwork() {
        UserSocialNetworkData socialNetworkData = new UserSocialNetworkData();
        socialNetworkData.setFacebookUrl("https://www.facebook.com/" + this.faker.name().username());
        socialNetworkData.setTwitterUrl("https://twitter.com/" + this.faker.name().username());
        socialNetworkData.setInstagramUrl("https://www.instagram.com/" + this.faker.name().username());
        return socialNetworkData;
    }

    private UserGeneralData generateGeneralData(String country) {
        if (isNull(country) || isNull(Country.getByCode(country))) {
            country = Country.getRandomValue();
        }
        UserGeneralData generalData = new UserGeneralData();
        generalData.setFirstName(this.faker.name().firstName());
        generalData.setLastName(this.faker.name().lastName());
        generalData.setGender(Gender.getRandomValue());
        generalData.setAddress(this.faker.address().fullAddress());
        generalData.setAge(this.faker.number().numberBetween(18, 80));
        generalData.setBirthDate(this.faker.date().birthday());
        generalData.setCountry(this.faker.address().country());
        generalData.setEmail(this.faker.internet().emailAddress());
        generalData.setPhoneNumber(this.faker.phoneNumber().cellPhone());
        generalData.setPictureUrl(this.userPictureUrlGenerator.generatePictureUrlBySexAndByAge(
                generalData.getGender(), generalData.getAge()));

        generalData.setCountryCode(country.toUpperCase());
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
