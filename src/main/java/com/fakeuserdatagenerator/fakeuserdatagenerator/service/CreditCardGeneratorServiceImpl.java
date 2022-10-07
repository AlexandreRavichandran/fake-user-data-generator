package com.fakeuserdatagenerator.fakeuserdatagenerator.service;

import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.PaymentType;
import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.CreditCardData;
import com.fakeuserdatagenerator.fakeuserdatagenerator.utils.general.RandomDateGenerator;
import com.fakeuserdatagenerator.fakeuserdatagenerator.utils.luhn.LuhnAlgorithmGenerator;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Random;

import static java.util.Objects.isNull;

@Service
public class CreditCardGeneratorServiceImpl implements CreditCardGeneratorService{

    @Autowired
    private Faker faker;

    @Autowired
    private RandomDateGenerator randomDateGenerator;

    @Autowired
    private LuhnAlgorithmGenerator luhnAlgorithmGenerator;

    public CreditCardData generate(@Nullable String paymentType) {
        if (isNull(paymentType)) {
            paymentType = PaymentType.getRandom().name();
        }
        CreditCardData creditCardData = new CreditCardData();
        creditCardData.setCardNumber(this.generateNumberByPaymentType(PaymentType.valueOf(paymentType)));
        creditCardData.setExpirationDate(this.generateExpirationDate());
        creditCardData.setCvc(this.generateCVV());

        return creditCardData;
    }

    private String generateNumberByPaymentType(PaymentType paymentType) {
        return this.luhnAlgorithmGenerator.generateByPaymentType(paymentType);
    }

    private String generateExpirationDate() {

        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/yyyy");

        return dateFormatter.format(this.randomDateGenerator.getRandomDateGenerator());
    }

    private String generateCVV() {
        Random random = new Random();
        return String.valueOf( random.nextInt(999));
    }

}
