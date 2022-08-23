package com.fakeuserdatagenerator.fakeuserdatagenerator.domain;

import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.Gender;
import lombok.Data;

import java.util.Date;

@Data
public class UserGeneralData {

    private String lastName;
    private String firstName;
    private String gender;
    private Integer age;
    private Date birthDate;
    private String pictureUrl;
    private String address;
    private String country;
    private String email;
    private String phoneNumber;
    private String countryCode;

}
