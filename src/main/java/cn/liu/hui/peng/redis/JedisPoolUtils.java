package cn.liu.hui.peng.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @description: redis连接池，懒汉模式 需要加锁才能保证不会出现同步问题。
 * @author: liuhp534
 * @create: 2019-05-19 10:56
 */
public class JedisPoolUtils {

    private static JedisPool jedisPool = null;


    public static JedisPool getInstance() {
        if (null == jedisPool) {
            synchronized (JedisPoolUtils.class) {
                if (null == jedisPool) {
                    //设置
                    JedisPoolConfig poolConfig = new JedisPoolConfig();
                    poolConfig.setMaxIdle(32);
                    poolConfig.setTestOnBorrow(true);
                    jedisPool = new JedisPool(poolConfig, RedisCommon.Host, RedisCommon.Port);
                }
            }
        }
        return jedisPool;
    }
}
