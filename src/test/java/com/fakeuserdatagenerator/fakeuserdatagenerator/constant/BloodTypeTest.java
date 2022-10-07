package com.fakeuserdatagenerator.fakeuserdatagenerator.constant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BloodTypeTest {

    @Test
    void shouldReturnRandomBloodTypeEnumValue() {
        List<String> possibleValues = new ArrayList<>(Arrays.asList(
                "A+",
                "A-",
                "B+",
                "B-",
                "AB+",
                "AB-",
                "O+",
                "O-"));

        String testBloodType = BloodType.getRandomValue();
        assertTrue(possibleValues.contains(testBloodType));
    }
}