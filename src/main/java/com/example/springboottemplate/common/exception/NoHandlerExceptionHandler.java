package com.example.springboottemplate.common.exception;

import com.example.springboottemplate.common.dto.response.ResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 处理 404、500 等默认 noHandleException，返回 JSON 格式数据，替代 HTML 格式返回
 */
@RestController
public class NoHandlerExceptionHandler implements ErrorController {
    @Autowired
    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return "/error";
    }


    @RequestMapping(value = "/error")
    public ResponseException noHandlerExceptionHandler(HttpServletRequest request) {
        // https://blog.csdn.net/weixin_42034623/article/details/90293402
        int statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        // https://blog.csdn.net/jwf111/article/details/88571067
        ServletWebRequest requestAttributes = new ServletWebRequest(request);
        Map<String, Object> attr = this.errorAttributes.getErrorAttributes(requestAttributes, false);
        ResponseException responseException = new ResponseException(statusCode, (String) attr.get("message"));

        return responseException;
    }
}
