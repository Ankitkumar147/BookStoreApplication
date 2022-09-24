package com.bridgelabz.Controller;

import com.bridgelabz.DTO.LoginDto;
import com.bridgelabz.DTO.ResponseDto;
import com.bridgelabz.DTO.UserDto;
import com.bridgelabz.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @RequestMapping(value = {"","/","/home"}, method = RequestMethod.GET)
    public String homePage() {
        return "Hello! This is Book Store Application Home Page";
    }

    @PostMapping("/register")
    public ResponseEntity<String>registerUser(@Valid @RequestBody UserDto userdto){
        String newUser = userService.registerUser(userdto);
        ResponseDto responseDto = new ResponseDto("User Registered Successfully...", newUser);
        return new ResponseEntity(responseDto, HttpStatus.CREATED);
    }

    @PostMapping("/loginUser")
    public ResponseEntity<ResponseDto> loginUser(@RequestBody LoginDto dto, BindingResult result){
        ResponseDto responseDto = new ResponseDto("Login Successful....",userService.loginUser(dto));
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
    @GetMapping("/ListUsers")
    public ResponseEntity<ResponseDto>getAllUser(){
        ResponseDto responseDto = new ResponseDto("List of Users---->",userService.getAllUser());
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }

}
