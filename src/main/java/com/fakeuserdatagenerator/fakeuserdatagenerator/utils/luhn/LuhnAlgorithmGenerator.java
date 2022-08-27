package com.fakeuserdatagenerator.fakeuserdatagenerator.utils.luhn;

import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.PaymentType;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class LuhnAlgorithmGenerator {

    private static final List<String> AMERICAN_EXPRESS_SECOND_VALUE = new ArrayList<>(Arrays.asList("4", "7"));

    @Autowired
    private Faker faker;

    public String generateByPaymentType(PaymentType paymentType) {
        String numberWithoutLastDigit = "";
        switch (paymentType) {
            case VISA:
                numberWithoutLastDigit = this.generateVisaCreditCardNumber();
                break;
            case AMERICAN_EXPRESS:
                numberWithoutLastDigit = this.generateAmericanExpressCreditCardNumber();
                break;
            case MASTERCARD:
                numberWithoutLastDigit = this.generateMasterCardCreditCardNumber();
                break;
        }

        return this.calculateLastDigit(numberWithoutLastDigit);
    }

    private String calculateLastDigit(String creditCardWithoutLastDigit) {
        int lastDigitValue = 0;
        int valueToAdd;

        List<String> numberList = new ArrayList<>(List.of(creditCardWithoutLastDigit.split("(?<=.)")));
        Collections.reverse(numberList);

        for (int i = 0; i < numberList.size(); i++) {
            if (i % 2 == 0) {
                valueToAdd = Integer.parseInt(numberList.get(i)) * 2;
                if (valueToAdd >= 10) {
                    List<String> separatedInteger = List.of(Integer.toString(valueToAdd).split("(?<=.)"));
                    valueToAdd = Integer.parseInt(separatedInteger.get(0)) + Integer.parseInt(separatedInteger.get(1));
                }
            } else {
                valueToAdd = Integer.parseInt(numberList.get(i));
            }
            lastDigitValue += valueToAdd;
        }

        lastDigitValue = 10 - (lastDigitValue % 10);

        return creditCardWithoutLastDigit + lastDigitValue;
    }

    private String generateMasterCardCreditCardNumber() {

        return "5" + this.faker.number().digits(14);
    }

    private String generateVisaCreditCardNumber() {

        return "4" + this.faker.number().digits(14);

    }

    private String generateAmericanExpressCreditCardNumber() {

        return "3" + AMERICAN_EXPRESS_SECOND_VALUE.get(this.faker.number().numberBetween(0, 1)) +
                this.faker.number().digits(13);

    }
}
