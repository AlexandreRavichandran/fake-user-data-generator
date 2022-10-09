package com.fakeuserdatagenerator.fakeuserdatagenerator.service;

import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserData;

import java.util.*;

public interface UserDataGeneratorService {

    UserData generateFakeUserByNecessaryDatas(UserData userData, String country);

    List<UserData> generateManyFakeUserByNecessaryData(UserData userData, String country, String number);
}
