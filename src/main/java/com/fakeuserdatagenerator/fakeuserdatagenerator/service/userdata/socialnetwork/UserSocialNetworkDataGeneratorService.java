package com.fakeuserdatagenerator.fakeuserdatagenerator.service.userdata.socialnetwork;

import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserGeneralData;
import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserSocialNetworkData;
import com.fakeuserdatagenerator.fakeuserdatagenerator.utils.general.RandomDataGenerator;

public interface UserSocialNetworkDataGeneratorService {

    UserSocialNetworkData generateSocialNetwork(RandomDataGenerator randomDataGenerator, UserGeneralData userGeneralData);
}
