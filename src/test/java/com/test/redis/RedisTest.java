package com.test.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by Wangpeng on 2017/9/29.
 */
public class RedisTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("106.15.36.146", 6379);
        jedis.auth("P@sswordredis");
        System.out.println(jedis.ping());
    }

}
