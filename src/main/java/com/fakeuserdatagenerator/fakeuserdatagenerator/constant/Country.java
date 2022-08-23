package com.fakeuserdatagenerator.fakeuserdatagenerator.constant;


import java.util.Random;

public enum Country {
    CA("Catalan", "ca"),
    DE("German", "de"),
    EN("English", "en"),
    ES("Spanish", "es"),
    FA("Farsi", "fa"),
    FI("Finnish", "fi"),
    FR("French", "fr"),
    HE("Hebrew", "he"),
    IT("Italian", "it"),
    JA("Japanese", "ja"),
    KO("Korean", "ko"),
    NL("Dutch", "nl"),
    PL("Polish", "pl"),
    PT("Portugese", "pt"),
    RU("Russian", "ru"),
    SK("Slovak", "sk"),
    SV("Swedish", "sv"),
    UK("Ukrainian", "uk"),
    VI("Vietnamese", "vi");

    private final String label;
    private final String code;

    Country(String label, String code) {
        this.label = label;
        this.code = code;
    }

    public static Country getByCode(String searchedLabel) {
        for (Country value : Country.values()) {
            if (searchedLabel.equals(value.code)) {
                return value;
            }
        }
        return null;
    }

    public static String getRandomValue(){
        return Country.values()[new Random().nextInt(Country.values().length)].code;
    }

}
