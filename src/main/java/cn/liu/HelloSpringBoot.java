package cn.liu;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: hello类 test
 * @author: hz16092620
 * @create: 2019-03-07 10:51
 */
@RestController
public class HelloSpringBoot {


    @RequestMapping("helloBoot")
    public Map<String, Object> sayHello(@RequestParam(value="name", defaultValue="World")String name) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        return map;
    }
}
