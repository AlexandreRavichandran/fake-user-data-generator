package com.fakeuserdatagenerator.fakeuserdatagenerator.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class UserPictureUrlGeneratorTest {

    @Autowired
    @InjectMocks
    UserPictureUrlGenerator userPictureUrlGenerator;

    @Test
    void whenGivenSexAndAgeShouldReturnPictureUrl() {
        String searchedGender = "male";
        Integer searchedAge = 34;

        String testPictureUrl = this.userPictureUrlGenerator.generatePictureUrlBySexAndByAge(searchedGender, searchedAge);

        assertTrue(testPictureUrl.contains(searchedGender));
        assertTrue(testPictureUrl.contains("young"));
    }
}