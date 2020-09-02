package zxp.springbootstudy.config.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import zxp.springbootstudy.model.ResponseResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {

    private ObjectMapper objectMapper;

    public LoginInterceptor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /*
            Controller中请求的方法执行前，就会调用preHandle，返回值决定是否在继续执行Controller中的方法
            return true:继续执行Controller中的方法
            return false:不执行了
        */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        // 登陆允许访问
        if (session != null && session.getAttribute("user") != null) {
            return true;
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        // 不允许访问，可以通过response对象，但会json数据，或者重定向到某个页面
        ResponseResult r = new ResponseResult();
        r.setCode("ERROR401");
        r.setMessage("用户未登录不允许访问");
        String json = objectMapper.writeValueAsString(r); // 将Java对象序列化为json字符串
        PrintWriter pw = response.getWriter();
        pw.println(json);
        pw.flush();
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
}
