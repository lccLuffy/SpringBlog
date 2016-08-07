package com.lcc.blog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

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
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
            super.postHandle(request, response, handler, modelAndView);
            System.out.println("start>>------------------------------------------------");
            System.out.println(modelAndView.getViewName());
            for (Map.Entry<String, Object> entry : modelAndView.getModel().entrySet()) {
                System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
            }
            System.out.println("------------------------------------------------end<<");
        }
    }

}
