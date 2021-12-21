package com.renaissance.common.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.renaissance.common.api.CommonResult;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 功能描述
 *
 * @author weishanyuan
 * @since 2021-10-14
 */
@ControllerAdvice
@Setter(onMethod=@__({@Autowired}))
@Slf4j
public class ResponseBodyResultAdvice implements ResponseBodyAdvice<Object> {

    private static String[] basePackages = new String[]{"com.renaissance"};
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        Class<?> declaringClass = returnType.getMember().getDeclaringClass();
        for (int i = 0; i < basePackages.length; i++) {
            if (declaringClass.getPackage().getName().startsWith(basePackages[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
        Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
        ServerHttpResponse response) {
        CommonResult<Object> result = CommonResult.success(body);
        if (returnType.getGenericParameterType().equals(String.class)) {
            try {
                response.getHeaders().set("Content-Type", "application/json;charset=utf-8");
                return objectMapper.writeValueAsString(result);
            } catch (JsonProcessingException e) {
                log.error(this.getClass().getSimpleName(), e);
            }
        }
        return result;
    }
}
