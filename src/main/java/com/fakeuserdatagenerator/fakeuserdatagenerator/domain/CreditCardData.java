package com.fakeuserdatagenerator.fakeuserdatagenerator.domain;

import lombok.Data;

@Data
public class CreditCardData {

    private String cardNumber;
    private String expirationDate;
    private String cvc;
}
