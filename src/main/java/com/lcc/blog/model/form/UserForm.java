package com.lcc.blog.model.form;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by lcc_luffy on 2016/7/27.
 */
public class UserForm {
    @Size(min = 3, max = 16)
    private String username;

    @Size(min = 6, max = 16)
    private String password;

    @Size(min = 6, max = 16)
    private String password_confirm;

    @Email
    @NotNull
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_confirm() {
        return password_confirm;
    }

    public void setPassword_confirm(String password_confirm) {
        this.password_confirm = password_confirm;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "UserForm{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", password_confirm='" + password_confirm + '\'' +
                '}';
    }
}
