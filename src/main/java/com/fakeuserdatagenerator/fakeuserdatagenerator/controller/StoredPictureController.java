package com.fakeuserdatagenerator.fakeuserdatagenerator.controller;

import com.fakeuserdatagenerator.fakeuserdatagenerator.service.StoredPictureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/api/storage/pictures")
public class StoredPictureController {

    @Autowired
    StoredPictureServiceImpl storedPictureService;

    @GetMapping(value = "/{sex}/{age}/{name}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getPictureByName(@PathVariable("sex") String sex, @PathVariable("age") String age, @PathVariable("name") String name) throws IOException {
        InputStream picture = this.storedPictureService.getPictureByAgeAndSexAndName(age,sex,name);

        if(isNull(picture)){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new InputStreamResource(picture),HttpStatus.OK);
    }
}
