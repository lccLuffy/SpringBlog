package com.lcc.blog.service;

import com.lcc.blog.model.User;
import com.lcc.blog.model.form.UserForm;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by lcc_luffy on 2016/7/25.
 */
public interface UserService extends UserDetailsService {
    void createUser(UserForm userForm);

    User findByUsername(String username);

    User findById(Long id);
}
