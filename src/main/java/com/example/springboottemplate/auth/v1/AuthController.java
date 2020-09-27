package com.example.springboottemplate.auth.v1;

import com.example.springboottemplate.auth.v1.dto.LoginDto;
import com.example.springboottemplate.common.enums.ResponseCodeAndMsg;
import com.example.springboottemplate.common.exception.ApiException;
import com.example.springboottemplate.common.utils.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto) {
        if (loginDto.getUserName().equals("alex") && loginDto.getPassword().equals("123456")) {
            Map map = new HashMap<String, String>();

            map.put("userName", loginDto.getUserName());
            map.put("password", loginDto.getPassword());

            return JwtUtil.sign(map);
        } else {
            throw new ApiException(ResponseCodeAndMsg.LOG_IN_INFO_ERROR);
        }
    }
}
