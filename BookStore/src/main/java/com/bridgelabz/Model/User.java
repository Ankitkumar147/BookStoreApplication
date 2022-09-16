package com.bridgelabz.Model;

import com.bridgelabz.DTO.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Users")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String userName;
    private String email;
    private String password;

    public User(UserDto userDto)
    {
        this.userName = userDto.getUserName();
        this.email = userDto.getEmail();
        this.password= userDto.getPassword();
    }

}