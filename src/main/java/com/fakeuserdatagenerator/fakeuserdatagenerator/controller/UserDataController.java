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

import java.util.*;

import static java.util.Objects.isNull;


@RestController
@RequestMapping("/api/generate/users")
public class UserDataController {

    @Autowired
    UserDataGeneratorServiceImpl userDataGeneratorService;

    @GetMapping()
    public ResponseEntity<UserData> browse(@Nullable @RequestParam("datatypes") List<String> dataTypes,
                                           @Nullable @RequestParam("sex") String sex,
                                           @Nullable @RequestParam("ageRange") String[] ageRange,
                                           @Nullable @RequestParam("country") String country,
                                           @Nullable @RequestParam("number") Long number) {


        UserData userData = this.initializeUserDataByNecessaryDataTypes(dataTypes);
        return new ResponseEntity<>(this.userDataGeneratorService.generateFakeUserByNecessaryDatas(userData, country), HttpStatus.OK);
    }

    public UserData initializeUserDataByNecessaryDataTypes(List<String> dataTypes){
        UserData userData = new UserData();

        if(isNull(dataTypes) || dataTypes.isEmpty()){
            dataTypes = Arrays.asList("physical","general","preference","credit-card","social-network");
        }

        for (String dataType : dataTypes) {
            switch (dataType){
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

        return Boolean.FALSE.equals(this.checkIfUserDataIsEmpty(userData)) ? userData : null;
    }

    private Boolean checkIfUserDataIsEmpty(UserData userData){
        return isNull(userData.getGeneralData()) &&
                isNull(userData.getPhysicalData()) &&
                isNull(userData.getSocialNetwork()) &&
                isNull(userData.getPreference()) &&
                isNull(userData.getCreditCard());
    }
}
