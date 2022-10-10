package com.fakeuserdatagenerator.fakeuserdatagenerator.service.userdata.socialnetwork;

import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserSocialNetworkData;
import com.github.javafaker.Faker;

public interface UserSocialNetworkDataGeneratorService {

    UserSocialNetworkData generateSocialNetwork(Faker faker);
}
