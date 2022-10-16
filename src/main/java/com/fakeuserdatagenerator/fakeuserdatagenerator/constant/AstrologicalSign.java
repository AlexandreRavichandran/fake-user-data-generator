package com.fakeuserdatagenerator.fakeuserdatagenerator.constant;

import java.util.Random;

public enum AstrologicalSign {
    ARIES("Aries"),
    TAURUS("Taurus"),
    GEMINI("Gemini"),
    CANCER("Cancer"),
    LEO("Leo"),
    VIRGO("Virgo"),
    LIBRA("Libra"),
    SCORPIO("Scorpio"),
    SAGITTARIUS("Sagittarius"),
    CAPRICORN("Capricorn"),
    AQUARIUS("Aquarius"),
    PISCES("Pisces");

    private final String label;

    AstrologicalSign(String label) {
        this.label = label;
    }

    public String getLabel(){
        return this.label;
    }

    public static String getRandomValue() {
        return AstrologicalSign.values()[new Random().nextInt(AstrologicalSign.values().length)].label;
    }
}
