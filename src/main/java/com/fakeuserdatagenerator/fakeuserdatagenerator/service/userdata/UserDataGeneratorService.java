package com.fakeuserdatagenerator.fakeuserdatagenerator.service.userdata;

import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserData;

import java.util.List;

public interface UserDataGeneratorService {

    UserData generateFakeUserByNecessaryDatas(UserData userData, String country, String sex);

    List<UserData> generateManyFakeUserByNecessaryData(UserData userData, String country, String sex, String number);
}
