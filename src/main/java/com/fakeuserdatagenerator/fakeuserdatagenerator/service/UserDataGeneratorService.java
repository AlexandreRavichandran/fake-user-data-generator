package com.fakeuserdatagenerator.fakeuserdatagenerator.service;

import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserData;

public interface UserDataGeneratorService {

    UserData generateFakeUserByNecessaryDatas(UserData userData, String country);
}
