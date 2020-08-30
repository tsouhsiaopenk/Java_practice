package zxp.springbootstudy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    @ResponseBody
    public Object login(){
        Map<String,String> map = new HashMap<>();
        map.put("一","1");
        map.put("二","2");
        return map;
    }
}
