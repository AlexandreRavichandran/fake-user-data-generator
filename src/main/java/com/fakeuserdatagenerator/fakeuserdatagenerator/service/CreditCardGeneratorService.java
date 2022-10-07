package com.fakeuserdatagenerator.fakeuserdatagenerator.service;

import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.CreditCardData;
import org.springframework.lang.Nullable;

public interface CreditCardGeneratorService {

    CreditCardData generate(@Nullable String paymentType);
}
