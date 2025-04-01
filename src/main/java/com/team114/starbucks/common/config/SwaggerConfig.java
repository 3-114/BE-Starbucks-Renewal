//package com.team114.starbucks.common.config;
//
//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
//import io.swagger.v3.oas.annotations.security.SecurityScheme;
//import org.springdoc.core.models.GroupedOpenApi;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//// Swagger URL : http://localhost:8080/swagger-ui/index.html
//@OpenAPIDefinition(
//        info = @io.swagger.v3.oas.annotations.info.Info(
//                title = "114-STARBUCKS-Renewal Service API",
//                version = "v1.0.0",
//                description = "114-STARBUCKS-Renewal API Test"
//        )
//)
//@SecurityScheme(
//        name = "Bearer Auth",
//        type = SecuritySchemeType.HTTP,
//        bearerFormat = "JWT",
//        scheme = "bearer"
//)
//
//@Profile("!prod")
//@Configuration
//public class SwaggerConfig {
//
//    @Bean
//    public GroupedOpenApi publicApi() {
//        String[] paths = { "/api/v1/**" };
//        return GroupedOpenApi.builder()
//                .group("public-api")
//                .pathsToMatch(paths)
//                .build();
//    }
//
//}
