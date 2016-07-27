package com.lcc.blog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lcc_luffy on 2016/7/27.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Bean
    public BlogInterceptor blogInterceptor() {
        return new BlogInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(blogInterceptor());
    }

    private class BlogInterceptor extends HandlerInterceptorAdapter {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            System.out.println(request.getRemoteUser());
            System.out.println(request.getSession().toString());
            request.setAttribute("io", "java");
            return true;
        }
    }
}
