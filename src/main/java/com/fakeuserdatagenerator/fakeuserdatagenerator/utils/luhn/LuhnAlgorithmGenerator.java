package com.fakeuserdatagenerator.fakeuserdatagenerator.utils.luhn;

import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.PaymentType;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class LuhnAlgorithmGenerator {

    private static final List<String> AMERICAN_EXPRESS_SECOND_VALUE = new ArrayList<>(Arrays.asList("4", "7"));

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

        return "5" + this.generateRandomNumber(14);
    }

    private String generateVisaCreditCardNumber() {

        return "4" + this.generateRandomNumber(14);

    }

    private String generateAmericanExpressCreditCardNumber() {
        Random random = new Random();
        return "3"
                + AMERICAN_EXPRESS_SECOND_VALUE.get(random.nextInt(1))
                + this.generateRandomNumber(13);

    }

    private String generateRandomNumber(Integer numberOfNumbers) {
        Random random = new Random();
        StringBuilder numbers = new StringBuilder();
        for (int i = 0; i <= numberOfNumbers; i++) {
            Integer randomNumber = random.nextInt(9);
            numbers.append(randomNumber);
        }

        return numbers.toString();
    }
}
