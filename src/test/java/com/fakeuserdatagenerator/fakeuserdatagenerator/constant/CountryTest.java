package com.fakeuserdatagenerator.fakeuserdatagenerator.constant;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CountryTest {

    @Test
    void whenGivenCodeShouldReturnRelatedCountryEnumValue() {
    }

    @Test
    void shouldReturnRandomCountryEnumValue() {
        List<String> possibleValues = new ArrayList<>(Arrays.asList(
                "ca",
                "de",
                "en",
                "es",
                "fa",
                "fi",
                "fr",
                "he",
                "it",
                "ja",
                "ko",
                "nl",
                "pl",
                "pt",
                "ru",
                "sk",
                "sv",
                "uk",
                "vi"
        ));

        String testCountry = Country.getRandomValue();
        assertTrue(possibleValues.contains(testCountry));
    }
}