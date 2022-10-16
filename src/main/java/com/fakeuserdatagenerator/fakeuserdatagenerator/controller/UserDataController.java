package com.fakeuserdatagenerator.fakeuserdatagenerator.controller;

import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.*;
import com.fakeuserdatagenerator.fakeuserdatagenerator.service.userdata.UserDataGeneratorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

import java.util.Arrays;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;


@RestController
@RequestMapping("/api/users")
public class UserDataController {

    @Autowired
    UserDataGeneratorServiceImpl userDataGeneratorService;

    @GetMapping
    @Operation(
            summary = "Generate one or many user datas",
            tags = "User data generator",
            description = "This route can generate some user datas to be used for your application. You can custom your " +
                    "query by adding specific parameters for the generated users, like their gender, their age, or the number " +
                    "of user to generate. You can also choose what type of user data you currently want. It can be for example general datas like name, age, address.. " +
                    "but it can also be more specific datas like datas related to physical, preferences, social network links..")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Generated user datas",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserData.class)) }),
    })
    public ResponseEntity<Object> browse(
            @Parameter(name = "data-types", description = "Type of user data that have to be generated. Default value : all datas.")
            @Nullable @RequestParam("data-types") List<String> dataTypes,
            @Parameter(description = "Gender of user that have to be generated. Default value : random.") @Nullable @RequestParam("sex") String sex,
            @Parameter(name = "age-range", description = "Range of age of users. Default value : random.") @Nullable @RequestParam("age-range") String[] ageRange,
            @Parameter(description = "Country of generated users. Can impact on their names and address. Default value : random.") @Nullable @RequestParam("country") String country,
            @Parameter(description = "Number of user that have to be generated. Default value : 1.") @Nullable @RequestParam("number") String number) {

        Object result;
        UserData userData = this.initializeUserDataByNecessaryDataTypes(dataTypes);

        if (nonNull(number) && Integer.parseInt(number) > 1) {
            result = this.userDataGeneratorService.generateManyFakeUserByNecessaryData(userData, country, sex, number);
        } else {
            result = this.userDataGeneratorService.generateFakeUserByNecessaryDatas(userData, country, sex);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private UserData initializeUserDataByNecessaryDataTypes(List<String> dataTypes) {
        UserData userData = new UserData();

        if (isNull(dataTypes) || dataTypes.isEmpty() || (dataTypes.size() == 1 && dataTypes.get(0).equals("all"))) {
            dataTypes = Arrays.asList("physical", "general", "preference", "credit-card", "social-network");
        }

        for (String dataType : dataTypes) {
            switch (dataType) {
                case "physical":
                    userData.setPhysicalData(new UserPhysicalData());
                    break;
                case "general":
                    userData.setGeneralData(new UserGeneralData());
                    break;
                case "preference":
                    userData.setPreference(new UserPreferenceData());
                    break;
                case "credit-card":
                    userData.setCreditCard(new CreditCardData());
                    break;
                case "social-network":
                    userData.setSocialNetwork(new UserSocialNetworkData());
                    break;
                default:
                    break;
            }
        }

        return userData;
    }

}
