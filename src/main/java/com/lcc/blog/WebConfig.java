package com.lcc.blog;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by lcc_luffy on 2016/7/27.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    /*@Bean
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
            System.out.println("WebConfig:" + request.getRequestURI());
            return true;
        }
    }*/

}
