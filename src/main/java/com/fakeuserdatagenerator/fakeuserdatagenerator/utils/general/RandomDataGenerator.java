package com.fakeuserdatagenerator.fakeuserdatagenerator.utils.general;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Random;

@Component
public class RandomDataGenerator {

    Faker faker;

    Locale locale;

    public void setLocale(Locale locale) {
        this.locale = locale;
        this.faker = new Faker(locale);
    }

    public String getFirstName(){
        return this.faker.name().firstName();
    }

    public String getLastName(){
        return this.faker.name().lastName();
    }


    public String getJobTitle(){
        return this.faker.job().title();
    }

    public Integer getRandomNumberBetween(Integer beginning, Integer ending){
        Random random = new Random();
        return (int) ((random.nextInt() * (ending - beginning)) + beginning);
    }

    public String getAddress(){
        return this.faker.address().streetAddress();
    }

    public String getCountryCode(){
        return this.faker.address().countryCode();
    }

    public String getEmail(){
        return this.faker.internet().emailAddress();
    }

    public String getPhoneNumber(){
        return this.faker.phoneNumber().cellPhone();
    }

    public String getUsername(){
        return this.faker.name().username();
    }

    public String getFoodType(){
        return this.faker.demographic().demonym() + " food";
    }


}
