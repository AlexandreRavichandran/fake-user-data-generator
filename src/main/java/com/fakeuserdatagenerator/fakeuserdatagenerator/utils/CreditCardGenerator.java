package com.fakeuserdatagenerator.fakeuserdatagenerator.utils;

import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.PaymentType;
import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.CreditCardData;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
public class CreditCardGenerator {

    @Autowired
    private Faker faker;

    public CreditCardData generate(String paymentType) {
        CreditCardData creditCardData = new CreditCardData();
        creditCardData.setCardNumber(this.generateNumberByPaymentType(PaymentType.valueOf(paymentType)));
        creditCardData.setExpirationDate(this.generateExpirationDate());
        creditCardData.setCvc(this.generateCVV());

        return creditCardData;
    }

    private String generateNumberByPaymentType(PaymentType paymentType) {
        String cardNumber = "0";
        switch (paymentType) {
            case VISA:
                cardNumber = this.generateVisaCardNumber();
                break;
            case MASTERCARD:
                cardNumber = this.generateMastercardCardNumber();
                break;
            case AMERICAN_EXPRESS:
                cardNumber = this.generateAmericanExpressCardNumber();
                break;
        }

        return cardNumber;
    }

    private String generateExpirationDate() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/yyyy");

        return dateFormatter.format(this.faker.date().future(365, TimeUnit.DAYS));
    }

    private String generateCVV() {
        return String.valueOf(this.faker.number().numberBetween(100, 999));
    }

    private String generateVisaCardNumber() {
        List<String> numberGroups = new ArrayList<>();

        numberGroups.add("4" + this.faker.number().numberBetween(0, 999));

        for (int i = 0; i < 3; i++) {
            numberGroups.add(String.valueOf(this.faker.number().numberBetween(1000, 9999)));
        }

        return String.join(" ", numberGroups).trim();

    }

    private String generateMastercardCardNumber() {
        List<String> numberGroups = new ArrayList<>();

        numberGroups.add("5" + this.faker.number().numberBetween(0, 999));

        for (int i = 0; i < 3; i++) {
            numberGroups.add(String.valueOf(this.faker.number().numberBetween(1000, 9999)));
        }

        return String.join(" ", numberGroups).trim();
    }

    private String generateAmericanExpressCardNumber() {
        List<Integer> randomNumbers = Arrays.asList(4, 7);
        List<String> numberGroups = new ArrayList<>();

        numberGroups.add("3" +
                randomNumbers.get(this.faker.number().numberBetween(0, 1)) +
                this.faker.number().numberBetween(10, 99));

        for (int i = 0; i < 2; i++) {
            numberGroups.add(String.valueOf(this.faker.number().numberBetween(1000, 9999)));
        }

        numberGroups.add(String.valueOf(this.faker.number().numberBetween(100, 999)));

        return String.join(" ", numberGroups).trim();
    }

}
