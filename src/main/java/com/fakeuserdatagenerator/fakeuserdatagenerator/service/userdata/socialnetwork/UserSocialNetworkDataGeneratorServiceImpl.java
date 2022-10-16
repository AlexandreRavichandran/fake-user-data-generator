package com.fakeuserdatagenerator.fakeuserdatagenerator.service.userdata.socialnetwork;

import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.SocialNetworkUrlConstant;
import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserGeneralData;
import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserSocialNetworkData;
import com.fakeuserdatagenerator.fakeuserdatagenerator.utils.general.RandomDataGenerator;
import org.springframework.stereotype.Service;

@Service
public class UserSocialNetworkDataGeneratorServiceImpl implements UserSocialNetworkDataGeneratorService {

    public UserSocialNetworkData generateSocialNetwork(RandomDataGenerator randomDataGenerator, UserGeneralData userGeneralData) {
        UserSocialNetworkData socialNetworkData = new UserSocialNetworkData();
        socialNetworkData.setFacebookUrl(SocialNetworkUrlConstant.FACEBOOK_PROFILE_BASE_URL + userGeneralData.getFirstName().toLowerCase() + "." + userGeneralData.getLastName().toLowerCase());
        socialNetworkData.setTwitterUrl(SocialNetworkUrlConstant.TWITTER_PROFILE_BASE_URL + userGeneralData.getFirstName().toLowerCase() + "." + userGeneralData.getLastName().toLowerCase());
        socialNetworkData.setInstagramUrl(SocialNetworkUrlConstant.INSTAGRAM_PROFILE_BASE_URL + userGeneralData.getFirstName().toLowerCase() + "." + userGeneralData.getLastName().toLowerCase());
        return socialNetworkData;
    }


}
