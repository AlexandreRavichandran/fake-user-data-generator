package com.fakeuserdatagenerator.fakeuserdatagenerator.service;

import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.CreditCardData;
import org.springframework.lang.Nullable;

import java.util.*;

public interface CreditCardGeneratorService {

    CreditCardData generate(@Nullable String paymentType);

    List<CreditCardData> generateSeveral(@Nullable String paymentType, String number);
}
