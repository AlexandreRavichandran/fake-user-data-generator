package com.fakeuserdatagenerator.fakeuserdatagenerator.controller;

import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.PaymentType;
import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.CreditCardData;
import com.fakeuserdatagenerator.fakeuserdatagenerator.utils.CreditCardGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/api/generate/creditcards")
public class CreditCardDataController {

    @Autowired
    CreditCardGenerator creditCardGenerator;

    @GetMapping("/{type}")
    public ResponseEntity<CreditCardData> generateRandom(@PathVariable("type") String type){
        return new ResponseEntity<>(this.creditCardGenerator.generate(type.toUpperCase(Locale.ROOT)), HttpStatus.OK);
    }
}
