package com.fakeuserdatagenerator.fakeuserdatagenerator.utils;

import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.Gender;
import org.springframework.stereotype.Component;

@Component
public class UserPictureUrlGenerator {

    public static final String BASE_URL = "/resource";
    public static final String YOUNG_USER_PICTURE_URL = "/young";
    public static final String MIDDLE_USER_PICTURE_URL = "/middle";
    public static final String OLD_USER_PICTURE_URL = "/old";
    public static final String MAN_PICTURE_URL = "/male";
    public static final String WOMAN_PICTURE_URL = "/female";


    public String generatePictureUrlBySexAndByAge(String sex, Integer age) {

        return BASE_URL + this.getLinkBySex(sex) + this.getLinkByAge(age);
    }

    private String getLinkBySex(String sex) {
        String url;

        if (Gender.FEMALE.name().equals(sex)) {
            url = MAN_PICTURE_URL;
        } else {
            url = WOMAN_PICTURE_URL;
        }

        return url;
    }

    private String getLinkByAge(Integer age) {
        String url;

            if (age >= 18 && age < 30) {
            url = YOUNG_USER_PICTURE_URL;
        } else if (age >= 38 && age < 50) {
            url = MIDDLE_USER_PICTURE_URL;
        } else {
            url = OLD_USER_PICTURE_URL;
        }

        return url;
    }
}
