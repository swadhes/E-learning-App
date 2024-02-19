package com.elearning.platform.controller;

import com.elearning.platform.dto.UserDto;
import com.elearning.platform.services.core.impl.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/register")
    public String newUser(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "register";
    }

    @PostMapping(value = "/register")
    public String saveUser(UserDto userDto, Model model) {
        try {
            userService.createUser(userDto);
            return "registered";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

}
