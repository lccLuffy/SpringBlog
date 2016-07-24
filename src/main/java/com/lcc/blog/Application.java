package com.lcc.blog;

import com.lcc.blog.model.Post;
import com.lcc.blog.model.User;
import com.lcc.blog.repository.PostRepository;
import com.lcc.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.apache.coyote.http11.Constants.a;

/**
 * Created by lcc_luffy on 2016/7/23.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = userRepository.findOne(1L);
        if (user == null) {
            user = new User("lcc_luffy", "528360256@qq.com", "123456");
            userRepository.save(user);
        }

        /*List<Post> posts = new ArrayList<Post>(50);
        for (int i = 0; i < 50; i++) {
            Post post = new Post();
            post.setTitle("title"+i);
            post.setContent("content"+i);
            post.setUser(user);
            post.setHtmlContent("HtmlContent"+i);
            posts.add(post);
        }
        postRepository.save(posts);*/
        System.out.println(postRepository.findByUser(user).size());
    }
}
