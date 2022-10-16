package com.fakeuserdatagenerator.fakeuserdatagenerator.controller;

import com.fakeuserdatagenerator.fakeuserdatagenerator.domain.UserData;
import com.fakeuserdatagenerator.fakeuserdatagenerator.service.StoredPictureServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/api/storage/pictures")
public class StoredPictureController {

    @Autowired
    StoredPictureServiceImpl storedPictureService;

    @GetMapping(produces = MediaType.IMAGE_JPEG_VALUE)
    @Operation(
            summary = "Generate a user picture from the APi storage",
            tags = "Picture generator",
            description = "This route can generate an user picture based on informations given in the parameters. Pictures comes from" +
                    "'Thispersondoesnotexists' website.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Generated user picture",
                    content = { @Content(mediaType = "image/jpeg",
                            schema = @Schema(implementation = UserData.class)) }),
    })
    public ResponseEntity<InputStreamResource> read(@RequestParam("sex") String sex, @RequestParam("age") String age, @RequestParam("name") String name){
        InputStream picture = this.storedPictureService.getPictureByAgeAndSexAndName(age,sex,name);

        if(isNull(picture)){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new InputStreamResource(picture),HttpStatus.OK);
    }
}
