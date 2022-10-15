package com.fakeuserdatagenerator.fakeuserdatagenerator.service;

import java.io.InputStream;

public interface StoredPictureService {

    InputStream getPictureByAgeAndSexAndName(String age, String sex, String name);

}
