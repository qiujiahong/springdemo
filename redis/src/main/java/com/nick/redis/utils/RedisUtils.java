package com.nick.redis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {

    private static JedisPool pool;
    private static String host="192.168.80.11";
    private static int port = 6379;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMinIdle(5);
        pool  = new JedisPool(config,host,port);
    }

    public static Jedis getJedis(){
        return pool.getResource();
    }

    /**
     * 获取分布式锁
     *
     * @param lockKey
     * @param requestId
     * @param timeout
     * @return
     */
    public static boolean getLock(String lockKey, String requestId, int timeout) {

        Jedis jedis = getJedis();
        // NX 不存在的时候才能获得
        // EX 秒
        String result = jedis.set(lockKey,requestId,"NX","EX",timeout);
        if("OK".equalsIgnoreCase(result))
            return true;

        return false;
    }

    public static boolean getLock2(String lockKey, String requestId, int timeout) {
        Jedis jedis = getJedis();
        // NX 不存在的时候才能获得
        // EX 秒
        Long result = jedis.setnx(lockKey,requestId);
        if(result == 1){
            jedis.expire(lockKey,timeout);
            return true;
        }
        return false;
    }
    public static void releaseLock(String lockKey, String requestId){
        Jedis jedis= getJedis();
        if(requestId.equalsIgnoreCase(jedis.get(lockKey))){
            jedis.del(lockKey);
        }
    }

    public static void main(String[] args) {
        poolConnect();
    }

    public static void singleConnect() {
        Jedis je = new Jedis(host, port);
        String name = je.get("name");
        System.out.println(name);
        je.close();
    }

    public static void poolConnect() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMinIdle(5);

        JedisPool pool = new JedisPool(host, port);
        Jedis jedis = pool.getResource();
        String name = jedis.get("name");
        System.out.println(name);
        jedis.close();
        pool.close();
    }
}
