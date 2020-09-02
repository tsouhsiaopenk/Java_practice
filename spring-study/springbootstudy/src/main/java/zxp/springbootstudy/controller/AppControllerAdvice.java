package zxp.springbootstudy.controller;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import zxp.springbootstudy.model.ResponseResult;

// 指定身份：拦截Controller中web请求的类
@ControllerAdvice
public class AppControllerAdvice implements ResponseBodyAdvice<Object> {
    /*
    * 异常：
    * （1）自定义异常：可以携带自定义的错误信息（中文：可以给用户看）
    * （2）JDK和框架，程序代码运行时抛出，
    * */

    // 指定处理请求方法中抛出的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handle(Exception e){
        e.printStackTrace();
        return null;
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        ResponseResult r = new ResponseResult();
        r.setSuccess(true);
        r.setData(o);
        return r;
    }
}
