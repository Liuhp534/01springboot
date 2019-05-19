package cn.liu.hui.peng.redis;

import redis.clients.jedis.Jedis;

/**
 * @description: redis测试类
 * @author: liuhp534
 * @create: 2019-05-18 15:15
 */
public class RedisTest {

    public static void main(String[] args) {
        pingRedis();
    }

    private static void pingRedis() {
        Jedis jedis = new Jedis("192.168.8.130", 6379);
        System.out.println(jedis.ping());
        jedis.set("k1", "v1");
        System.out.println(jedis.get("k1"));
    }
}
