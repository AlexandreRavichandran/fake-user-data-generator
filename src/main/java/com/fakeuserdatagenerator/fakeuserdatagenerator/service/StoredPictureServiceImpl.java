package com.fakeuserdatagenerator.fakeuserdatagenerator.service;

import com.fakeuserdatagenerator.fakeuserdatagenerator.utils.UserPictureUrlGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class StoredPictureServiceImpl implements StoredPictureService {

    @Autowired
    UserPictureUrlGenerator userPictureUrlGenerator;

    @Override
    public InputStream getPictureByAgeAndSexAndName(String age, String sex, String name) {
        String relatedPicturePath = this.userPictureUrlGenerator.generateDirectoryPathByAgeAndSex(sex,Integer.parseInt(age));

        return this.getClass().getResourceAsStream(relatedPicturePath + "/" + name);


    }




}
