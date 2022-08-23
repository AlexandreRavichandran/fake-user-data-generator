package com.fakeuserdatagenerator.fakeuserdatagenerator.constant;

import java.util.Random;

public enum Gender {
    FEMALE("Female"),
    MALE("Male");

    private final String label;

    Gender(String label) {
        this.label = label;
    }

    public static String getRandomValue(){
        return Gender.values()[new Random().nextInt(Gender.values().length)].label;
    }
}
