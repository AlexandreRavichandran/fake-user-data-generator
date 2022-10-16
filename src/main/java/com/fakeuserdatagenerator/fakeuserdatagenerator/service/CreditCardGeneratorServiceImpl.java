package com.fakeuserdatagenerator.fakeuserdatagenerator.service;

import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.PaymentType;
import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.CreditCardData;
import com.fakeuserdatagenerator.fakeuserdatagenerator.utils.general.RandomDateGenerator;
import com.fakeuserdatagenerator.fakeuserdatagenerator.utils.luhn.LuhnAlgorithmGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Objects.isNull;

@Service
public class CreditCardGeneratorServiceImpl implements CreditCardGeneratorService{

    @Autowired
    private RandomDateGenerator randomDateGenerator;

    @Autowired
    private LuhnAlgorithmGenerator luhnAlgorithmGenerator;

    @Override
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

    @Override
    public List<CreditCardData> generateSeveral(String paymentType, String number) {
        List<CreditCardData> creditCardData = new ArrayList<>();
        if (Integer.parseInt(number) > 0){
            for (int i = 1; i <= Integer.parseInt(number) ; i++) {
                creditCardData.add(this.generate(paymentType));
            }
        }

        return creditCardData;
    }

    private String generateNumberByPaymentType(PaymentType paymentType) {
        return this.luhnAlgorithmGenerator.generateByPaymentType(paymentType);
    }

    private String generateExpirationDate() {

        return this.randomDateGenerator.getRandomFutureDate("MM/yyyy");
    }

    private String generateCVV() {
        Random random = new Random();
        return String.valueOf( random.nextInt(999));
    }

}
