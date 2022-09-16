package com.bridgelabz.AppConfiguration;

import com.bridgelabz.Model.BookEntity;
import com.bridgelabz.Model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public User user(){
        return new User();
    }
    @Bean
    public BookEntity bookEntity(){
        return new BookEntity();
    }
}
