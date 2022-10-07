package com.fakeuserdatagenerator.fakeuserdatagenerator.constant;

import java.util.Random;

public enum PaymentType {
    VISA("Visa"),
    MASTERCARD("Mastercard"),
    AMERICAN_EXPRESS("American-Express");

    private final String label;

    PaymentType(String label) {
        this.label = label;
    }


    public static PaymentType getRandom() {
        return PaymentType.values()[new Random().nextInt(PaymentType.values().length)];
    }


}
