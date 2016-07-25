package com.lcc.blog.service;

import com.lcc.blog.model.User;
import com.lcc.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * Created by lcc_luffy on 2016/7/25.
 */
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername:" + s);
        User user = userRepository.findByUsername(s);
        if (user == null) {
            System.out.println(s + " not found,have you register?");
            throw new UsernameNotFoundException(s + " not found,have you register?");
        }
        return new BlogUserDetails(user.getId(), user.getUsername(), user.getPassword(), true, true, true, true, Collections.singleton(grantedAuthority("User")));
    }

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    private GrantedAuthority grantedAuthority(String authority) {
        return new SimpleGrantedAuthority(authority);
    }
}
