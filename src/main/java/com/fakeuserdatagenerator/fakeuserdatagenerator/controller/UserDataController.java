package com.fakeuserdatagenerator.fakeuserdatagenerator.controller;

import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.*;
import com.fakeuserdatagenerator.fakeuserdatagenerator.utils.FakeUserGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/generate/users")
public class UserDataController {

    @Autowired
    FakeUserGenerator fakeUserGenerator;

    @GetMapping()
    public ResponseEntity<UserData> browse(@Nullable @RequestParam("datatypes") String[] dataTypes,
                                           @Nullable @RequestParam("sex") String sex,
                                           @Nullable @RequestParam("ageRange") String[] ageRange,
                                           @Nullable @RequestParam("country") String country,
                                           @Nullable @RequestParam("number") Long number) {

        UserData userData = new UserData();
        userData.setPhysicalData(new UserPhysicalData());
        userData.setGeneralData(new UserGeneralData());
        userData.setPreference(new UserPreferenceData());
        userData.setCreditCard(new CreditCardData());
        return new ResponseEntity<>(this.fakeUserGenerator.generateFakeUserByNecessaryDatas(userData, "fr"), HttpStatus.OK);
    }

}
