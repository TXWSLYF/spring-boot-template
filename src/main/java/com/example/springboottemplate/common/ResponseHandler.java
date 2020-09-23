package com.example.springboottemplate.common;

import com.alibaba.fastjson.JSON;
import com.example.springboottemplate.common.dto.response.ResponseSuccess;
import com.example.springboottemplate.common.dto.response.ResponseException;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 统一 response 封装
 * https://blog.csdn.net/shenhuxi10000/article/details/104622770
 */
@ControllerAdvice(basePackages = "com.example.springboottemplate")
public class ResponseHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(final MethodParameter methodParameter, final Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    /**
     * 处理 response 的具体业务方法
     */
    @Override
    public Object beforeBodyWrite(Object response, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        // 返回异常的情况
        if (response instanceof ResponseException) {
            return response;
        }

        ResponseSuccess responseSuccess = new ResponseSuccess(response);


        /**
         * 返回为字符串的情况，需要修改 header 的 contentType，并且手动序列化
         * https://stackoverflow.com/questions/51828879/springboot-controller-return-data-through-responsebodyadvice-occur-an-error-cl
         * https://jpanj.com/2018/SpringBoot-%E4%B8%AD%E7%BB%9F%E4%B8%80%E5%8C%85%E8%A3%85%E5%93%8D%E5%BA%94/
         */
        if (response instanceof String) {
            serverHttpResponse.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return JSON.toJSONString(responseSuccess);
        }

        return responseSuccess;
    }
}
