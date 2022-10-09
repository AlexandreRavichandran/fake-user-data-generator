package com.fakeuserdatagenerator.fakeuserdatagenerator.controller;

import com.fakeuserdatagenerator.fakeuserdatagenerator.service.CreditCardGeneratorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/api/generate/creditcards")
public class CreditCardDataController {

    @Autowired
    CreditCardGeneratorServiceImpl creditCardGeneratorService;

    @GetMapping("/")
    public ResponseEntity<Object> generateRandom(@Nullable @RequestParam("type") String type, @Nullable @RequestParam("number") String number) {

        Object result;
        String paymentType = nonNull(type) ? type.toUpperCase(Locale.ROOT) : null;

        if (nonNull(number) && Integer.parseInt(number) > 1) {
            result = this.creditCardGeneratorService.generateSeveral(paymentType, number);
        } else {
            result = this.creditCardGeneratorService.generate(paymentType);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
