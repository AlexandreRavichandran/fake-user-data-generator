package com.fakeuserdatagenerator.fakeuserdatagenerator.constant;

import lombok.Data;

import java.util.Random;

public enum Gender {
    FEMALE("Female"),
    MALE("Male");

    private final String label;

    Gender(String label) {
        this.label = label;
    }

    public static String getRandomValue() {
        return Gender.values()[new Random().nextInt(Gender.values().length)].label;
    }

    public static Gender getByCode(String searchedLabel) {
        for (Gender value : Gender.values()) {
            if (searchedLabel.equals(value.label)) {
                return value;
            }
        }
        return null;
    }

    public String getLabel(){
        return this.label;
    }
}
