package com.fakeuserdatagenerator.fakeuserdatagenerator.constant;

import java.util.Random;

public enum BloodType {
    A_POSITIVE("A+"),
    A_NEGATIVE("A-"),
    B_POSITIVE("B+"),
    B_NEGATIVE("B-"),
    AB_POSITIVE("AB+"),
    AB_NEGATIVE("AB-"),
    O_POSITIVE("O+"),
    O_NEGATIVE("O-");

    private final String symbol;

    BloodType(String symbol) {
        this.symbol = symbol;
    }

    public static String getRandomValue(){
        return BloodType.values()[new Random().nextInt(BloodType.values().length)].symbol;
    }

}
