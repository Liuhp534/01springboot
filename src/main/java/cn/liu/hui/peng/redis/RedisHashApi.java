package cn.liu.hui.peng.redis;

import redis.clients.jedis.Jedis;

/**
 * @description: redis基本使用测试
 * @author: liuhp534
 * @create: 2019-05-19 09:46
 */
public class RedisHashApi {

    private static Jedis jedis = null;

    static {
        //jedis = JedisPoolUtils.getInstance().getResource();//这个会一直保持连接状态，线程在运行。
        jedis = new Jedis(RedisCommon.Host, RedisCommon.Port);
        jedis.select(5);
        //jedis.flushDB();//只清楚当前数据库
    }

    public static void main(String[] args) {
        hash();
        hashnx();
    }

    private static void hashnx() {
        System.out.println(jedis.hsetnx("hash2", "name", "jeff"));
        System.out.println(jedis.hsetnx("hash2", "name", "john"));
        System.out.println(jedis.hget("hash2", "name"));//返回 jeff v中的键有就算，值不同，也算有对应的数据
    }

    private static void hash() {
        System.out.println(jedis.hset("hash1", "name", "jeff"));//返回1
        System.out.println(jedis.hset("hash1", "name", "john"));//返回0 值能够设置成功
        System.out.println(jedis.hget("hash1", "name"));//返回 john
    }


}
