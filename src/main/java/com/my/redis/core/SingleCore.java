package com.my.redis.core;

import com.my.redis.dao.impl.RedisDateSourceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * Created by mac on 16/8/30.
 * @author Milo.S
 * @version 1.0.0
 */
@Service
public class SingleCore {

    @Autowired
    private RedisDateSourceImpl redisDateSource;

    public void set(String key , String value){
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            redisDateSource.returnResource(jedis);
        }
    }

    public String get(String key){
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
            return jedis.get(key);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            redisDateSource.returnResource(jedis);
        }
    }


//         .   2 many methods
//         .
//         .
//         .
//         .
//         .


}
