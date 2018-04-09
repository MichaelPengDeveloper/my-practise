package com.test.redis;

import redis.clients.jedis.Jedis;

import java.util.Random;

/**
 * Created by Wangpeng on 2018/4/9.
 */
public class RedisLock {

    /**
     * 加锁标志
     */
    public static final String LOCKED = "TRUE";
    /**
     * 毫秒与毫微秒的换算单位 1毫秒 = 1000000毫微秒
     */
    public static final long MILLI_NANO_CONVERSION = 1000 * 1000L;
    /**
     * 默认超时时间（毫秒）
     */
    public static final long DEFAULT_TIME_OUT = 1000;
    public static final Random RANDOM = new Random();

    /**
     * 锁的超时时间（秒），过期删除
     */
    public static final int EXPIRE = 3 * 60;
    private static volatile int add = 10;
    private Jedis jedis;
    private String key;
    // 锁状态标志
    private boolean locked = false;

    public RedisLock(String key) {
        this.key = key + "_lock";
        this.jedis = new Jedis("106.15.36.146", 6379, 60000);
    }

    public static void main(String[] args) {
        long nano = System.nanoTime();
        System.out.println(System.nanoTime() - nano);
    }

    /**
     * 加锁
     * 应该以：
     * lock();
     * try {
     * doSomething();
     * } finally {
     * unlock()；
     * }
     * 的方式调用
     *
     * @param timeout 超时时间
     * @return 成功或失败标志
     */
    public boolean lock(long timeout) {
        long nano = System.nanoTime();
        timeout *= MILLI_NANO_CONVERSION;
        try {
            while ((System.nanoTime() - nano) < timeout) {
                if (this.jedis.setnx(this.key, LOCKED) == 1) {
                    this.jedis.expire(this.key, EXPIRE);
                    this.locked = true;
                    return true;
                }
                // 短暂休眠，避免出现活锁
                Thread.sleep(3, RANDOM.nextInt(500));
            }
        } catch (Exception e) {
            throw new RuntimeException("Locking error", e);
        }
        return false;
    }

    /**
     * 加锁
     * 应该以：
     * lock();
     * try {
     * doSomething();
     * } finally {
     * unlock()；
     * }
     * 的方式调用
     *
     * @return 成功或失败标志
     */
    public boolean lock() {
        return lock(DEFAULT_TIME_OUT);
    }

    /**
     * 解锁
     * 无论是否加锁成功，都需要调用unlock
     * 应该以：
     * lock();
     * try {
     * doSomething();
     * } finally {
     * unlock()；
     * }
     * 的方式调用
     */
    @SuppressWarnings("deprecation")
    public void unlock() {
        try {
            if (this.locked) {
                this.jedis.del(this.key);
            }
        } catch (Exception e) {
            //
        }
    }

}
