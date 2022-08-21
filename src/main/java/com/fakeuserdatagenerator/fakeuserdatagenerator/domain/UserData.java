package com.fakeuserdatagenerator.fakeuserdatagenerator.domain;

import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.AstrologicalSign;
import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.BloodType;
import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.Gender;
import lombok.Data;

import java.util.Date;

@Data
public class UserData {

    private String lastName;
    private String firstName;
    private Gender gender;
    private Integer age;
    private Date birthDate;
    private String height;
    private String weight;
    private BloodType bloodType;
    private String pictureUrl;

    private String address;
    private String country;

    private String email;
    private String phoneNumber; //Faire une methode pour determiner la forme (., - ou tout attaché)
    private String countryCode;

    private AstrologicalSign astrologicalSign;

    private CreditCardData creditCardData;

    private String job;

}
