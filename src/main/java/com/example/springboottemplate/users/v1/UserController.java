package com.example.springboottemplate.users.v1;

import com.example.springboottemplate.common.utils.JwtUtil;
import com.example.springboottemplate.users.v1.dto.CreateUserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Value("${testname}")
    private String dataSource;

    @GetMapping("/alex")
    public CreateUserDto alex() throws Exception {
        CreateUserDto createUserDto = new CreateUserDto("alex", 25);

        return createUserDto;
    }

    @GetMapping("/500")
    public String error500() {
        int a = 5 / 0;

        return "1";
    }

    @GetMapping("/config")
    public String config() {
        return this.dataSource;
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @GetMapping("parseToken")
    public Object parseToken(@RequestParam("token") String token) {
        return JwtUtil.parse(token);
    }
}
