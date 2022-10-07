package com.fakeuserdatagenerator.fakeuserdatagenerator.controller;

import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.CreditCardData;
import com.fakeuserdatagenerator.fakeuserdatagenerator.service.CreditCardGeneratorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/api/generate/creditcards")
public class CreditCardDataController {

    @Autowired
    CreditCardGeneratorServiceImpl creditCardGeneratorService;

    @GetMapping()
    public ResponseEntity<CreditCardData> generateRandom(@Nullable @RequestParam("type") String type) {
        return new ResponseEntity<>(this.creditCardGeneratorService.generate(nonNull(type) ? type.toUpperCase(Locale.ROOT) : null), HttpStatus.OK);
    }
}
