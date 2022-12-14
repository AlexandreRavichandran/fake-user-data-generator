package com.fakeuserdatagenerator.fakeuserdatagenerator.service;

import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.PaymentType;
import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.CreditCardData;
import com.fakeuserdatagenerator.fakeuserdatagenerator.utils.general.RandomDateGenerator;
import com.fakeuserdatagenerator.fakeuserdatagenerator.utils.luhn.LuhnAlgorithmGenerator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreditCardGeneratorServiceImplTest {

    @InjectMocks
    CreditCardGeneratorServiceImpl creditCardGeneratorService;

    @Mock
    LuhnAlgorithmGenerator luhnAlgorithmGenerator;

    @Mock
    RandomDateGenerator randomDateGenerator;

    @Test
    @Disabled
    void whenGivenVisaEnumShouldReturnVisaCreditCardData() {
        String creditCardNumberTest = "111111111111111";
        Mockito.when(this.luhnAlgorithmGenerator.generateByPaymentType(PaymentType.VISA)).thenReturn(creditCardNumberTest);
        Mockito.when(this.randomDateGenerator.getRandomFutureDate("MM/yyyy")).thenReturn("12/2022");
        CreditCardData testVisaData = this.creditCardGeneratorService.generate(PaymentType.VISA.name());
        Mockito.verify(this.luhnAlgorithmGenerator).generateByPaymentType(PaymentType.VISA);

        assertSame("111111111111111", testVisaData.getCardNumber());
        assertTrue(testVisaData.getExpirationDate().matches("[0-1][0-9]/[0-9]{4}"));
        assertTrue(testVisaData.getCvc().matches("[0-9]{3}"));

    }

    @Test
    void whenGivenMastercardEnumShouldReturnMastercardCreditCardData() {
        String creditCardNumberTest = "111111111111111";
        Mockito.when(this.luhnAlgorithmGenerator.generateByPaymentType(PaymentType.MASTERCARD)).thenReturn(creditCardNumberTest);
        Mockito.when(this.randomDateGenerator.getRandomFutureDate("MM/yyyy")).thenReturn("12/2022");
        CreditCardData testVisaData = this.creditCardGeneratorService.generate(PaymentType.MASTERCARD.name());
        Mockito.verify(this.luhnAlgorithmGenerator).generateByPaymentType(PaymentType.MASTERCARD);

        assertSame("111111111111111", testVisaData.getCardNumber());
        assertTrue(testVisaData.getExpirationDate().matches("[0-1][0-9]/[0-9]{4}"));
        assertTrue(testVisaData.getCvc().matches("[0-9]{3}"));
    }

    @Test
    void whenGivenAmericanExpressEnumShouldReturnAmericanExpressCreditCardData() {
        String creditCardNumberTest = "111111111111111";
        Mockito.when(this.luhnAlgorithmGenerator.generateByPaymentType(PaymentType.AMERICAN_EXPRESS)).thenReturn(creditCardNumberTest);
        Mockito.when(this.randomDateGenerator.getRandomFutureDate("MM/yyyy")).thenReturn("12/2022");
        CreditCardData testVisaData = this.creditCardGeneratorService.generate(PaymentType.AMERICAN_EXPRESS.name());
        Mockito.verify(this.luhnAlgorithmGenerator).generateByPaymentType(PaymentType.AMERICAN_EXPRESS);

        assertSame("111111111111111", testVisaData.getCardNumber());
        assertTrue(testVisaData.getExpirationDate().matches("[0-1][0-9]/[0-9]{4}"));
        assertTrue(testVisaData.getCvc().matches("[0-9]{3}"));
    }

    @Test
    void whenGivenNoneEnumShouldReturnRandomCreditCardData() {

        String creditCardNumberTest = "111111111111111";
        Mockito.when(this.luhnAlgorithmGenerator.generateByPaymentType(PaymentType.AMERICAN_EXPRESS)).thenReturn(creditCardNumberTest);
        Mockito.when(this.randomDateGenerator.getRandomFutureDate("MM/yyyy")).thenReturn("12/2022");
        CreditCardData testVisaData = this.creditCardGeneratorService.generate(PaymentType.AMERICAN_EXPRESS.name());
        Mockito.verify(this.luhnAlgorithmGenerator).generateByPaymentType(PaymentType.AMERICAN_EXPRESS);

        assertSame("111111111111111", testVisaData.getCardNumber());
        assertTrue(testVisaData.getExpirationDate().matches("[0-1][0-9]/[0-9]{4}"));
        assertTrue(testVisaData.getCvc().matches("[0-9]{3}"));
    }

    @Test
    void whenGivenRandomEnumShouldReturnCreditCardDataList() {
        String numberOfCreditCard = "3";
        String firstCreditCardNumberTest = "111111111111111";

        Mockito.when(this.luhnAlgorithmGenerator.generateByPaymentType(PaymentType.VISA)).thenReturn(firstCreditCardNumberTest);
        Mockito.when(this.randomDateGenerator.getRandomFutureDate("MM/yyyy")).thenReturn("12/2022");

        List<CreditCardData> testCreditCardDataList = this.creditCardGeneratorService.generateSeveral(PaymentType.VISA.name(), numberOfCreditCard);

        assertEquals(Integer.parseInt(numberOfCreditCard), testCreditCardDataList.size());

        for (CreditCardData testCreditCardData : testCreditCardDataList) {
            assertEquals(firstCreditCardNumberTest, testCreditCardData.getCardNumber());
        }

    }
}