package com.fakeuserdatagenerator.fakeuserdatagenerator.domain;

import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.BloodType;
import lombok.Data;

@Data
public class UserPhysicalData {

    private String height;
    private String weight;
    private String bloodType;
}
