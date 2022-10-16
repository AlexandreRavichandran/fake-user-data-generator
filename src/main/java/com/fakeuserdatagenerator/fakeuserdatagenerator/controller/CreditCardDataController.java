package com.fakeuserdatagenerator.fakeuserdatagenerator.controller;

import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserData;
import com.fakeuserdatagenerator.fakeuserdatagenerator.service.CreditCardGeneratorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
@RequestMapping("/api/creditcards")
public class CreditCardDataController {

    @Autowired
    CreditCardGeneratorServiceImpl creditCardGeneratorService;

    @GetMapping
    @Operation(
            summary = "Generate one or many credit card datas",
            tags = "Credit card data generator",
            description = "This route can generate some credit card datas, especially credit card number, expiration date and " +
                    "CVV. The credit card number can be in several types, like Visa, Mastercard or American Express." +
                    " The important thing here is that generated credit card number are VALID. It means that you can use them to execute payment API" +
                    " like Paypal API or Stripe API.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Generated user datas",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserData.class)) }),
    })
    public ResponseEntity<Object> generateRandom(
            @Nullable @RequestParam("type") String type,
            @Nullable @RequestParam("number") String number) {

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
