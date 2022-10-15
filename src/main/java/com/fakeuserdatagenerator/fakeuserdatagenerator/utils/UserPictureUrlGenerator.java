package com.fakeuserdatagenerator.fakeuserdatagenerator.utils;

import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.Gender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Random;

import static java.util.Objects.isNull;

@Component
public class UserPictureUrlGenerator {

    @Value("${spring.environment}")
    public String environmentUrl;
    public static final String BASE_URL = "/images";
    public static final String YOUNG_USER_PICTURE_URL = "/young";
    public static final String MIDDLE_USER_PICTURE_URL = "/middle";
    public static final String OLD_USER_PICTURE_URL = "/old";
    public static final String MAN_PICTURE_URL = "/male";
    public static final String WOMAN_PICTURE_URL = "/female";


    public String generatePictureUrlBySexAndByAge(String sex, Integer age) {
        String picturePath;
        File relatedDirectoryPath = new File("src/main/resources" + this.generateDirectoryPathByAgeAndSex(sex, age));
        String[] pictures = relatedDirectoryPath.list();
        if (isNull(pictures) || pictures.length == 0) {
            return null;
        }
        if (pictures.length == 1) {
            picturePath = pictures[0];
        }else{
            Random random = new Random();
            picturePath = pictures[random.nextInt(pictures.length - 1)];
        }

        return this.environmentUrl + "/api/storage/pictures/" + sex + "/" + age + "/" + picturePath;
    }

    public String getLinkBySex(String sex) {
        String url;

        if (Gender.FEMALE.getLabel().equals(sex)) {
            url = WOMAN_PICTURE_URL;
        } else {
            url = MAN_PICTURE_URL;

        }

        return url;
    }

    public String getLinkByAge(Integer age) {
        String url;

        if (age >= 18 && age < 38) {
            url = YOUNG_USER_PICTURE_URL;
        } else if (age >= 38 && age < 50) {
            url = MIDDLE_USER_PICTURE_URL;
        } else {
            url = OLD_USER_PICTURE_URL;
        }

        return url;
    }

    public String generateDirectoryPathByAgeAndSex(String sex, Integer age) {
        return BASE_URL + this.getLinkBySex(sex) + this.getLinkByAge(age);
    }
}
