package cn.liu.hui.peng.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 异常处理类
 * @author: liuhp534
 * @create: 2019-03-16 20:50
 */
@ControllerAdvice
public class MyExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(value = {java.lang.Exception.class})
    public Map<String, Object> executeExption(Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("errorCode", 500);
        map.put("errorMsg", e.getMessage());
        return map;
    }

    @ResponseBody
    @ExceptionHandler(value = {MyBusinessException.class})
    public Map<String, Object> executeBusinessExption(Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("errorCode", 500);
        map.put("errorMsg", e.getMessage());
        return map;
    }
}
