package com.fakeuserdatagenerator.fakeuserdatagenerator.domain;

import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.AstrologicalSign;
import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.BloodType;
import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.Gender;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
public class UserData {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UserGeneralData generalData;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UserPhysicalData physicalData;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private AstrologicalSign astrologicalSign;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CreditCardData creditCard;

    private String job;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UserPreferenceData preference;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UserSocialNetworkData socialNetwork;

    public String getFormattedPhoneNumber(Integer type) {
        String formattedPhoneNumber = "";
        switch (type) {
            case 1:
                String[] results = this.getGeneralData().getPhoneNumber().split("(?<=\\G.{" + 2 + "})");
                formattedPhoneNumber = String.join("-", results);
                break;
            case 2:
                formattedPhoneNumber = this.getGeneralData().getPhoneNumber();
                break;
            default:
        }

        return formattedPhoneNumber;
    }
}
