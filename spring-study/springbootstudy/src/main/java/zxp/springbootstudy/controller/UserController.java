package zxp.springbootstudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import zxp.springbootstudy.model.User;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
// 当前类型注册实例到容器中，并指定为web请求的处理
@Controller
// @RequestMapping可以定义请求相关的配置，如路径，请求方法等等
@RequestMapping("/user")
public class UserController {


    @Autowired
    private Map<Integer,Integer> test1;


//    @RequestMapping("/login")
//    @ResponseBody // 返回application/json 的数据类型，返回值回序列化为json字符串
//    public Object login(){
//        return test1;
//    }
    /**
     * 两个注解的区别：
     *  存在同一个类型，多个实例对象时候，默认查找bean的名称为变量名的bean
     *  如果变量名和bean名称不一致，需要手动指定：
     *      （1）@Autowrired+@Qualifier("bean的名称")
     *      （2）@Resource(name="bean的名称")
     */

//    @Autowired
//    @Qualifier("user1")
//    private User user;

    @Resource(name="user1")
    private User user; // 变量名和bean名称不一致，@Resource要指定name为bean的名称


//    @RequestMapping("/login")
//    @ResponseBody
//    public Object login(){
//        return user1;
//    }



    @RequestMapping(value="/login",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Object login(User user, HttpServletRequest req){
        if (!"abc".equals(user.getUsername())){
            throw new RuntimeException("用户登陆失败");
        }
        HttpSession session = req.getSession();
        session.setAttribute("user",user);

        return user;
    }

    // TODO : 这里有个问题，这里访问不到，不知道为什么
//    @RequestMapping("/m")
//    public String m(){
//        return "index.html";
//    }

//    @RequestMapping("/n")
//    public String n(){
//        return "forward:login";
//    }

    // url为rest风格的请求
    // 路径中使用变量作为占位符
    @RequestMapping("/test/{key}")
    @ResponseBody
    public Object test1(@PathVariable("key") Integer k){
        System.out.println("===================" +test1.get(k));
        return test1;
    }

    // 请求GET /user/test2?k1=v1&k2=v2
    @RequestMapping(value = "/test2",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object test2(@RequestParam String k1,String k2){
        System.out.println(k1 +" :"+ k2);
        return test1;
    }

    @RequestMapping("/test3") // 默认支持get请求
    @ResponseBody
    public Object test3(User user){// 请求数据自动映射到参数类型的属性中
        System.out.println(user);
        return test1;
    }

    @RequestMapping("/test4")
    @ResponseBody
    public Object test4(){
        return null;
    }

    @RequestMapping("/test5")
    @ResponseBody
    public Object test5(){
        return "OK";
    }

    @RequestMapping("/test6")
    @ResponseBody
    public Object test6(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("test6测试" + req.getParameter("username"));
        System.out.println("test6测试" + req.getParameter("password"));
        return null;
    }

    @RequestMapping("/test7")
    @ResponseBody
    public Object test7(@RequestBody User user){
        System.out.println("==============" + user);
        return null;
    }
    /**
     * web开发经常存在需求：
     * 1.统一处理异常
     * 2.统一返回数据格式
     * 3.统一会话管理(登陆的敏感资源权限控制)
     */
    @RequestMapping("test8")
    @ResponseBody
    public Object test8(){
        throw new RuntimeException("数据库报错了！");
    }

}
