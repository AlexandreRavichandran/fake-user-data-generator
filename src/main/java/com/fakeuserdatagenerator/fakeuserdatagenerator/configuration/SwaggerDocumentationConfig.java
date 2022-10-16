package com.fakeuserdatagenerator.fakeuserdatagenerator.configuration;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info =
@Info(
        title = "Fake user data generator",
        version = "1.0.0",
        description = "API to generate fake user datas separated in different sections, like general (first name, last name, age), physical (weight, height) and others. This API can also generate credit card data like credit card numbers, expiration date and CVV.",
        contact = @Contact(
                name = "Alexandre RAVICHANDRAN",
                email = "alexandre.ravichandran@gmail.com",
                url = "https://alexandreravichandran.github.io"
        ),
        license = @License(
                name = "MIT license",
                url = "https://opensource.org/licenses/mit-license.php"
        )
)
)
public class SwaggerDocumentationConfig {
}
