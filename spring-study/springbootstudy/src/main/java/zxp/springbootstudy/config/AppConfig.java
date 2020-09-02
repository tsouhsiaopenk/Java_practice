package zxp.springbootstudy.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import zxp.springbootstudy.config.interceptor.LoginInterceptor;
import zxp.springbootstudy.model.User;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 实现用户会话管理的功能

        registry.addInterceptor(new LoginInterceptor(objectMapper)).addPathPatterns("/user/**").
                excludePathPatterns("/user/login");
    }



    @Bean
    public Map<Integer,Integer> test1(){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        return map;
    }

    @Bean
    public Map<Integer,Integer> test2(){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(3,3);
        map.put(4,4);
        return map;
    }

    @Bean
    public User user1(){
        User u = new User();
        u.setUsername("西安北");
        u.setPassword("123");
        return u;
    }

    @Bean
    public User user2(){
        User u = new User();
        u.setUsername("西安西");
        u.setPassword("456");
        return u;
    }
}
