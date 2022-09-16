package com.bridgelabz.Service;


import com.bridgelabz.DTO.LoginDto;
import com.bridgelabz.DTO.UserDto;
import com.bridgelabz.Model.User;
import com.bridgelabz.Response.Response;

import java.util.List;

public interface IUserService {

    public Response loginUser(LoginDto dto);
    String registerUser(UserDto userDTO);
    public List<User> getAllUser();
    public User getByUserId(Long userId);
}
