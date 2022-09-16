package com.bridgelabz.Service;

import com.bridgelabz.DTO.LoginDto;
import com.bridgelabz.DTO.UserDto;
import com.bridgelabz.Exception.CustomException;
import com.bridgelabz.Exception.UserBookRegistrationException;
import com.bridgelabz.Model.User;
import com.bridgelabz.Repository.UserRepository;
import com.bridgelabz.Response.Response;
import com.bridgelabz.email.EmailService;
import com.bridgelabz.util.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtToken jwt;

    @Autowired
    EmailService emailService;

    @Override
    public Response loginUser(LoginDto dto) {
            return null;
        }

    @Override
    public String registerUser(UserDto userDTO) throws UserBookRegistrationException {
        User user = new User(userDTO);
        userRepository.save(user);
        String token = jwt.createToken(user.getUserId());
        emailService.sendEmail(user.getEmail(),"Sample Mail.","Registered Successfully, hii : "
                +user.getUserName() + " Please click here to get your data -> "
                +"http://localhost:8080/user/getAll/" + token);
        return token;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getByUserId(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new CustomException("User Not Found By Id."));
    }
}
