package com.practice.jwtredisstudy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * 配置Swagger2类
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket docketCreat() {
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        List<Parameter> parameters = new ArrayList<>();
        parameterBuilder.name("Authorization").description("token授权")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false)
                .build();
        parameters.add(parameterBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.practice.jwtredisstudy.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameters)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("胡炀广", "https://github.com/huyangguang666", "861279237@qq.com");
        return new ApiInfoBuilder()
                .title("胡炀广的小demo")
                .description("token-redis demo")
                .contact(contact)
                .version("v1.0")
                .build();
    }
}
