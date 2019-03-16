package cn.liu.hui.peng.exception;

/**
 * @description: 自定义runtimeException
 * @author: liuhp534
 * @create: 2019-03-16 20:57
 */
public class MyBusinessException extends RuntimeException {

    public MyBusinessException(String message) {
        super(message);
    }
}
