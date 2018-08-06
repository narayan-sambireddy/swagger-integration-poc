package com.sai.swaggerpoc.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${api.version}")
    private String apiVersion;

    @Value("${api.title}")
    private String apiTitle;

    @Value("${api.description}")
    private String apiDescription;

    @Value("${api.packages-to-scan}")
    private String apiPackagesToScan;

    @Value("${api.contact-name}")
    private String apiContactName;

    @Value("${api.contact-email}")
    private String apiContactEmail;

    @Value("${api.contact-url}")
    private String apiContactUrl;

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title(apiTitle)
                        .description(apiDescription)
                        .version(apiVersion)
                        .contact(new Contact(apiContactName, apiContactUrl, apiContactEmail))
                        .build())
                .select()
                        .apis(RequestHandlerSelectors.basePackage(apiPackagesToScan))
                .build();
    }
}
