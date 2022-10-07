package com.fakeuserdatagenerator.fakeuserdatagenerator.constant;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PaymentTypeTest {

    @Test
    void shouldReturnRandomPaymentTypeEnumValue() {
        List<PaymentType> possibleValues = new ArrayList<>(Arrays.asList(
                PaymentType.VISA,
                PaymentType.MASTERCARD,
                PaymentType.AMERICAN_EXPRESS
        ));

        PaymentType testPaymentType = PaymentType.getRandom();
        assertTrue(possibleValues.contains(testPaymentType));
    }
}