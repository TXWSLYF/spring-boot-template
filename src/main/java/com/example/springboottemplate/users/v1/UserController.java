package com.example.springboottemplate.users.v1;

import com.example.springboottemplate.common.enums.ResponseCodeAndMsg;
import com.example.springboottemplate.common.exception.ApiException;
import com.example.springboottemplate.users.v1.dto.CreateUserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {

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

    @GetMapping("/create")
    public String create() {
        return "create";
    }
}
