package com.fakeuserdatagenerator.fakeuserdatagenerator.utils;

import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.PaymentType;
import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.CreditCardData;
import com.fakeuserdatagenerator.fakeuserdatagenerator.utils.luhn.LuhnAlgorithmGenerator;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import static java.util.Objects.isNull;

@Component
public class CreditCardGenerator {

    @Autowired
    private Faker faker;

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

        return dateFormatter.format(this.faker.date().future(365, TimeUnit.DAYS));
    }

    private String generateCVV() {
        return String.valueOf(this.faker.number().numberBetween(100, 999));
    }


}
