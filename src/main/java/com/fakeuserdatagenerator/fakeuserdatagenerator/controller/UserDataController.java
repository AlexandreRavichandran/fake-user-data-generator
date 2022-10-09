package com.fakeuserdatagenerator.fakeuserdatagenerator.controller;

import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.*;
import com.fakeuserdatagenerator.fakeuserdatagenerator.service.UserDataGeneratorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;


@RestController
@RequestMapping("/api/generate/users")
public class UserDataController {

    @Autowired
    UserDataGeneratorServiceImpl userDataGeneratorService;

    @GetMapping("/")
    public ResponseEntity<Object> browse(@Nullable @RequestParam("datatypes") List<String> dataTypes,
                                             @Nullable @RequestParam("sex") String sex,
                                             @Nullable @RequestParam("ageRange") String[] ageRange,
                                             @Nullable @RequestParam("country") String country,
                                             @RequestParam("number") String number) {

        Object result;
        UserData userData = this.initializeUserDataByNecessaryDataTypes(dataTypes);

        if (nonNull(number) && Integer.parseInt(number) > 1) {
            result = this.userDataGeneratorService.generateManyFakeUserByNecessaryData(userData, country, number);
        } else {
            result = this.userDataGeneratorService.generateFakeUserByNecessaryDatas(userData, country);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private UserData initializeUserDataByNecessaryDataTypes(List<String> dataTypes) {
        UserData userData = new UserData();

        if (isNull(dataTypes) || dataTypes.isEmpty()) {
            dataTypes = Arrays.asList("physical", "general", "preference", "credit-card", "social-network");
        }

        for (String dataType : dataTypes) {
            switch (dataType) {
                case "physical":
                    userData.setPhysicalData(new UserPhysicalData());
                    break;
                case "general":
                    userData.setGeneralData(new UserGeneralData());
                    break;
                case "preference":
                    userData.setPreference(new UserPreferenceData());
                    break;
                case "credit-card":
                    userData.setCreditCard(new CreditCardData());
                    break;
                case "social-network":
                    userData.setSocialNetwork(new UserSocialNetworkData());
                    break;
                default:
                    break;
            }
        }

        return userData;
    }

}
