package com.fakeuserdatagenerator.fakeuserdatagenerator.constant;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GenderTest {

    @Test
    void shouldReturnRandomGenderEnumValue() {
        List<String> possibleValues = new ArrayList<>(Arrays.asList(
                "Male",
                "Female"
        ));

        String testGender = Gender.getRandomValue();
        assertTrue(possibleValues.contains(testGender));
    }
}