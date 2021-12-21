package com.renaissance.admin.config;

import com.renaissance.common.config.BaseSwaggerConfig;
import com.renaissance.common.model.SwaggerProperties;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.context.annotation.Configuration;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.renaissance.admin.controller")
                .title("mall后台系统")
                .description("mall后台相关接口文档")
                .contactName("wsy")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
