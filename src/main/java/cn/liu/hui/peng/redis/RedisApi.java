package cn.liu.hui.peng.redis;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

/**
 * @description: redis基本使用测试
 * @author: liuhp534
 * @create: 2019-05-19 09:46
 */
public class RedisApi {

    private static Jedis jedis = null;

    static {
        jedis = new Jedis(RedisCommon.Host, RedisCommon.Port);
    }

    public static void main(String[] args) {
        testSetString();
        testKeys();
    }

    /*设置字符串值*/
    private static void testSetString() {
        jedis.select(3);
        jedis.set("k1", "v1");
        jedis.set("k2", "v2");
    }

    /*查看对应库下面的所有key*/
    private static void testKeys() {

        jedis.select(3);
        Set<String> set =  jedis.keys("*");
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }


}
