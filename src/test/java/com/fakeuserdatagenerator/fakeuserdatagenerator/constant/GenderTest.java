package com.fakeuserdatagenerator.fakeuserdatagenerator.constant;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void whenGivenLabelShouldReturnRelatedGenderEnumValue() {
        String label = "Male";

        Gender testGender = Gender.getByCode(label);

        assertEquals(Gender.MALE,testGender);
    }

    @Test
    void whenGivenWrongLabelShouldReturnNull(){
        String wrongLabel = "test";

        Gender testGender = Gender.getByCode(wrongLabel);

        assertNull(testGender);
    }
}