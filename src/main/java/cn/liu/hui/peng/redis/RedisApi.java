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
        //jedis = JedisPoolUtils.getInstance().getResource();//这个会一直保持连接状态，线程在运行。
        jedis = new Jedis(RedisCommon.Host, RedisCommon.Port);
    }

    public static void main(String[] args) {
        testSetString();
        //testKeys();
        //testSetnx();
    }

    /*set if not exist 如果有设置值*/
    private static void testSetnx() {
        jedis.select(3);
        System.out.println(jedis.setnx("k2", "v2"));//0
        System.out.println(jedis.setnx("k3", "v3"));//1
    }

    /*设置字符串值*/
    private static void testSetString() {
        jedis.select(3);
        jedis.set("k1", "v1");
        jedis.set("k2", "v2");
        jedis.setex("k3", 20, "v3");//设置值，并且添加过期时间，单位秒
        System.out.println(jedis.ttl("k3"));//20
        System.out.println(jedis.getSet("k1", "v11"));//先获取再设置值，返回v1经过测试
    }

    /*查看对应库下面的所有key*/
    private static void testKeys() {

        jedis.select(3);
        Set<String> set =  jedis.keys("*");
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("--------------------");
        System.out.println(jedis.expire("k1", 20));//给k1设置过期时间20秒 返回0 or 1
        System.out.println(jedis.ttl("k1"));//查看k1多久过期还有 -2说明没有该key
        System.out.println(jedis.ttl("k2"));//查看k2多久过期还有 -1说明没有配置过期时间
        System.out.println(jedis.type("k2"));//查看属于说明类型
    }


}
