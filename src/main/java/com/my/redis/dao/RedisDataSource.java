package com.my.redis.dao;

import redis.clients.jedis.Jedis;

/**
 * Created by mac on 16/8/26.
 * @author Milo.S
 * @version 1.0.0
 */
public interface RedisDataSource {

    /*
    获取client single连接方法
     */
    public abstract Object getRedisClientForSingleServer();

    /*
    获取client cluster连接方法
     */
    public abstract Object getRedisClientForClusterServer();


    /*
    关闭client连接方法
     */
    public abstract void returnResource(Jedis jedis);

}
