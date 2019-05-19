package cn.liu.hui.peng.redis;

import redis.clients.jedis.Jedis;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/**
 * @description: redis基本使用测试
 * @author: liuhp534
 * @create: 2019-05-19 09:46
 */
public class RedisListApi {

    private static Jedis jedis = null;

    static {
        //jedis = JedisPoolUtils.getInstance().getResource();//这个会一直保持连接状态，线程在运行。
        jedis = new Jedis(RedisCommon.Host, RedisCommon.Port);
        jedis.select(4);
        jedis.flushDB();//只清楚当前数据库
    }

    public static void main(String[] args) {
        //setList();
        //pop();
        lrem();
    }

    private static void lrem() {
        System.out.println( jedis.rpush("list2", "1", "2", "3", "4", "5", "1", "1"));//右边入栈 可变参数添加元素 返回5 可以多次插入数据，不是覆盖
        System.out.println(jedis.lrem("list2", 2, "1"));//返回2
        System.out.println(jedis.lrange("list2", 0, -1));//[2, 3, 4, 5, 1]
    }

    private static void pop() {
        System.out.println(jedis.rpop("list2"));//取尾 5
        System.out.println(jedis.lpop("list2"));//取头 1
    }

    private static void setList() {
        System.out.println( jedis.lpush("list1", "1", "2", "3", "4", "5"));//左边入栈 可变参数添加元素 返回5 可以多次插入数据，不是覆盖
        System.out.println( jedis.rpush("list2", "1", "2", "3", "4", "5"));//右边入栈 可变参数添加元素 返回5 可以多次插入数据，不是覆盖
    }



}
