package com.fakeuserdatagenerator.fakeuserdatagenerator.service.userdata.socialnetwork;

import com.fakeuserdatagenerator.fakeuserdatagenerator.constant.SocialNetworkUrlConstant;
import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserSocialNetworkData;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

@Service
public class UserSocialNetworkDataGeneratorServiceImpl implements UserSocialNetworkDataGeneratorService {

    public UserSocialNetworkData generateSocialNetwork(Faker faker) {
        UserSocialNetworkData socialNetworkData = new UserSocialNetworkData();
        socialNetworkData.setFacebookUrl(SocialNetworkUrlConstant.FACEBOOK_PROFILE_BASE_URL + faker.name().username());
        socialNetworkData.setTwitterUrl(SocialNetworkUrlConstant.TWITTER_PROFILE_BASE_URL + faker.name().username());
        socialNetworkData.setInstagramUrl(SocialNetworkUrlConstant.INSTAGRAM_PROFILE_BASE_URL + faker.name().username());
        return socialNetworkData;
    }


}
