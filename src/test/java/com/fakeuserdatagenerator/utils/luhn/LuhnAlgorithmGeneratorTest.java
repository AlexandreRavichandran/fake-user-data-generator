package com.fakeuserdatagenerator.utils.luhn;

import com.fakeuserdatagenerator.fakeuserdatagenerator.utils.luhn.LuhnAlgorithmGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static com.fakeuserdatagenerator.fakeuserdatagenerator.constant.PaymentType.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LuhnAlgorithmGeneratorTest {

    @InjectMocks
    @Autowired
    LuhnAlgorithmGenerator luhnAlgorithmGenerator;

    @Test
    void whenGivenVisaEnumShouldReturnValidVisaCreditCardNumber() {
        String code = this.luhnAlgorithmGenerator.generateByPaymentType(VISA);
        assertEquals("4", String.valueOf(code.charAt(0)));
        assertTrue(this.checkLuhn(code));
    }

    @Test
    void whenGivenMastercardEnumShouldReturnValidMastercardCreditCardNumber() {
        String code = this.luhnAlgorithmGenerator.generateByPaymentType(MASTERCARD);

        assertEquals("5", String.valueOf(code.charAt(0)));
        assertTrue(this.checkLuhn(code));
    }

    @Test
    void whenGivenAmericanExpressEnumShouldReturnValidAmericanExpressCreditCardNumber() {
        String code = this.luhnAlgorithmGenerator.generateByPaymentType(AMERICAN_EXPRESS);

        assertEquals("3", String.valueOf(code.charAt(0)));
        assertTrue(("4".equals(String.valueOf(code.charAt(1)))) || ("7".equals(String.valueOf(code.charAt(1)))));
        assertTrue(this.checkLuhn(code));
    }

    private Boolean checkLuhn(String generatedCardNumber) {
        int totalValue = 0;
        int valueToAdd;
        List<String> numberList = new ArrayList<>(List.of(generatedCardNumber.split("(?<=.)")));
        String lastNumber = numberList.remove(numberList.size() - 1);
        Collections.reverse(numberList);
        for (int i = 0; i < numberList.size(); i++) {
            if (i % 2 == 0) {
                valueToAdd = Integer.parseInt(numberList.get(i)) * 2;
                if (valueToAdd >= 10) {
                    List<String> separatedInteger = List.of(Integer.toString(valueToAdd).split("(?<=.)"));
                    valueToAdd = Integer.parseInt(separatedInteger.get(0)) + Integer.parseInt(separatedInteger.get(1));
                }
            } else {
                valueToAdd = Integer.parseInt(numberList.get(i));
            }
            totalValue += valueToAdd;
        }

        return Integer.parseInt(lastNumber) == (10 - (totalValue % 10));

    }


}