package com.example.springboottemplate.common.exception;

import com.example.springboottemplate.common.dto.response.ResponseException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 * 处理 404、500 等默认 noHandleException，返回 JSON 格式数据，替代 HTML 格式返回
 */
@RestController
public class NoHandlerExceptionHandler implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping(value = "/error")
    public ResponseException noHandlerExceptionHandler(HttpServletRequest request) {
        // https://blog.csdn.net/weixin_42034623/article/details/90293402
        int statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        ResponseException responseException = new ResponseException(statusCode, HttpStatus.valueOf(statusCode).getReasonPhrase());

        return responseException;
    }
}
