package br.com.melpetspa.melpetspa.controller;

import br.com.melpetspa.melpetspa.dto.LoginRequestDTO;
import br.com.melpetspa.melpetspa.dto.User;
import br.com.melpetspa.melpetspa.service.UserService;
import br.com.melpetspa.melpetspa.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @Autowired
    public LoginController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/loginUser")
    public String loginUser(@RequestBody LoginRequestDTO loginRequest) {
        User user = userService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());
        return jwtUtil.generateToken(user.getUsername(), user.getAccessType());
    }

    @PostMapping("/loginClient")
    public String loginClient(@RequestBody LoginRequestDTO loginRequest) {
        User user = userService.authenticateClient(loginRequest.getUsername(), loginRequest.getPassword());
        return jwtUtil.generateToken(user.getUsername(), user.getAccessType());
    }
}
