package com.fakeuserdatagenerator.fakeuserdatagenerator.service.userdata;

import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.AstrologicalSign;
import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.Country;
import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.Gender;
import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.PaymentType;
import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserData;
import com.fakeuserdatagenerator.fakeuserdatagenerator.service.CreditCardGeneratorServiceImpl;
import com.fakeuserdatagenerator.fakeuserdatagenerator.service.userdata.general.UserGeneralDataGeneratorServiceImpl;
import com.fakeuserdatagenerator.fakeuserdatagenerator.service.userdata.physical.UserPhysicalDataGeneratorServiceImpl;
import com.fakeuserdatagenerator.fakeuserdatagenerator.service.userdata.preference.UserPreferenceDataGeneratorServiceImpl;
import com.fakeuserdatagenerator.fakeuserdatagenerator.service.userdata.socialnetwork.UserSocialNetworkDataGeneratorServiceImpl;
import com.fakeuserdatagenerator.fakeuserdatagenerator.utils.general.RandomDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class UserDataGeneratorServiceImpl implements UserDataGeneratorService {


    @Autowired
    UserGeneralDataGeneratorServiceImpl userGeneralDataGeneratorService;

    @Autowired
    UserPhysicalDataGeneratorServiceImpl userPhysicalDataGeneratorService;

    @Autowired
    UserSocialNetworkDataGeneratorServiceImpl userSocialNetworkDataGeneratorService;

    @Autowired
    UserPreferenceDataGeneratorServiceImpl userPreferenceDataGeneratorService;

    @Autowired
    CreditCardGeneratorServiceImpl creditCardGeneratorService;

    @Autowired
    RandomDataGenerator randomDataGenerator;

    @Override
    public UserData generateFakeUserByNecessaryDatas(UserData userData, String country, String sex) {
        HashMap<String, String> inputValues = this.initializeAllInputs(country, sex);
        this.initializeDataGeneratorByCountry(inputValues.get("country"));
        if (nonNull(userData.getGeneralData())) {
            if (isNull(country)) {
                inputValues.put("country", null);
            }
            userData.setGeneralData(this.userGeneralDataGeneratorService.generateGeneralData(this.randomDataGenerator, inputValues.get("country"), inputValues.get("sex")));
        }
        if (nonNull(userData.getPhysicalData())) {
            userData.setPhysicalData(this.userPhysicalDataGeneratorService.generatePhysicalData(this.randomDataGenerator));
        }

        if (nonNull(userData.getCreditCard())) {
            userData.setCreditCard(this.creditCardGeneratorService.generate(PaymentType.getRandom().name()));
        }

        if (nonNull(userData.getPreference())) {
            userData.setPreference(this.userPreferenceDataGeneratorService.generatePreferenceData(this.randomDataGenerator));
        }

        if (nonNull(userData.getSocialNetwork())) {
            userData.setSocialNetwork(this.userSocialNetworkDataGeneratorService.generateSocialNetwork(this.randomDataGenerator, userData.getGeneralData()));
        }

        userData.setAstrologicalSign(AstrologicalSign.getRandomValue());
        userData.setJob(this.randomDataGenerator.getJobTitle());
        return userData;
    }

    @Override
    public List<UserData> generateManyFakeUserByNecessaryData(UserData userData, String country, String sex, String number) {
        List<UserData> userDataList = new ArrayList<>();

        if (Integer.parseInt(number) > 0) {
            for (int i = 0; i <= Integer.parseInt(number); i++) {
                userDataList.add(this.generateFakeUserByNecessaryDatas(userData, country, sex));
            }
        }
        return userDataList;
    }

    private void initializeDataGeneratorByCountry(String country) {
        this.randomDataGenerator = new RandomDataGenerator();
        this.randomDataGenerator.setLocale(new Locale(country));
    }

    private HashMap<String, String> initializeAllInputs(String country, String sex) {
        HashMap<String, String> finalValues = new HashMap<>();

        if (isNull(country) || isNull(Country.getByCode(country.toLowerCase(Locale.ROOT)))) {
            finalValues.put("country", Country.getRandomValue());
        } else {
            finalValues.put("country", country);
        }

        if (isNull(sex) || isNull(Gender.getByCode(sex))) {
            finalValues.put("sex", Gender.getRandomValue());
        } else {
            finalValues.put("sex", sex);
        }

        return finalValues;
    }

}
