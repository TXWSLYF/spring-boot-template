package com.example.springboottemplate.users.v1;

import com.example.springboottemplate.users.v1.model.User;
import com.example.springboottemplate.users.v1.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Component
@RestController
@RequestMapping("/v1/user")
public class UserController {
    private UserRepository userRepository;

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    List<User> all() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<User> get(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @PostMapping
    User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    User edit(@PathVariable Long id, @RequestBody User newUser) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(newUser.getUsername());
            user.setPassword(newUser.getPassword());

            return userRepository.save(user);
        }).orElseGet(() -> {
            newUser.setId(id);
            return userRepository.save(newUser);
        });
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
