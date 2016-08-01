package com.lcc.blog;

import com.lcc.blog.repository.PostRepository;
import com.lcc.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.Validator;

/**
 * Created by lcc_luffy on 2016/7/23.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserService userService;

    @Override
    public void run(String... args) throws Exception {
        Validator v;
    }
}
