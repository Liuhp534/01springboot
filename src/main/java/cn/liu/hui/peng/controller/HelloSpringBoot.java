package cn.liu.hui.peng.controller;

import cn.liu.hui.peng.service.AsynService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: hello类 test test
 * @author: hz16092620
 * @create: 2019-03-07 10:51
 */
@RestController
public class HelloSpringBoot {

    private static final Logger logger = LoggerFactory.getLogger(HelloSpringBoot.class);

    @Autowired
    private AsynService asynService;

    @RequestMapping("helloBoot")
    public Map<String, Object> sayHello(@RequestParam(value="name", defaultValue="World")String name) {
        logger.info("----------helloBoot start----------");
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("time", asynService.execute());
        logger.info("----------helloBoot end----------");
        return map;
    }
}
