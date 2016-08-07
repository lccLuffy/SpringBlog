package com.lcc.blog;

import com.lcc.blog.service.UserService;
import com.lcc.blog.service.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by lcc_luffy on 2016/7/23.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder();
    }*/
}
