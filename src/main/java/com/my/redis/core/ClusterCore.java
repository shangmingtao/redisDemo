package com.my.redis.core;

import com.my.redis.dao.impl.RedisDateSourceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

/**
 * Created by mac on 16/8/30.
 * @author Milo.S
 * @version 1.0.0
 */
@Service
public class ClusterCore {
    @Autowired
    private RedisDateSourceImpl redisDateSource;

    public void set(String key , String value){
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = redisDateSource.getRedisClientForClusterServer();
            jedisCluster.set(key, value);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String get(String key){
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = redisDateSource.getRedisClientForClusterServer();
            return jedisCluster.get(key);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


//         .    many methods
//         .
//         .
//         .
//         .
//         .

}
