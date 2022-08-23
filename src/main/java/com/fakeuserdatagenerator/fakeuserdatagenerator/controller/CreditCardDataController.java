package com.fakeuserdatagenerator.fakeuserdatagenerator.controller;

import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.PaymentType;
import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.CreditCardData;
import com.fakeuserdatagenerator.fakeuserdatagenerator.utils.CreditCardGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/api/generate/creditcards")
public class CreditCardDataController {

    @Autowired
    CreditCardGenerator creditCardGenerator;

    @GetMapping()
    public ResponseEntity<CreditCardData> generateRandom(@Nullable @RequestParam("type") String type){
        return new ResponseEntity<>(this.creditCardGenerator.generate(type.toUpperCase()), HttpStatus.OK);
    }
}