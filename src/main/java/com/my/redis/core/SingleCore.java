package com.my.redis.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.my.redis.dao.impl.RedisDateSourceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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




    /***************************************************************
     ***********************  key and String ***********************
     ***************************************************************/

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

    public void setex(String key, String value, int seconds){
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
            jedis.setex(key, seconds, value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            redisDateSource.returnResource(jedis);
        }
    }

    public Long expire(String key ,int sec){
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
            return jedis.expire(key, sec);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            redisDateSource.returnResource(jedis);
        }
    }

    public Long del(String key){
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
            return jedis.del(key);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            redisDateSource.returnResource(jedis);
        }
    }

    public Boolean exists(String key){
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
            return jedis.exists(key);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            redisDateSource.returnResource(jedis);
        }
    }



    /***************************************************************
     ***********************      Hash       ***********************
     ***************************************************************/

    public Map<String, String> hgetall(String cid) {
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
            return jedis.hgetAll(cid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            redisDateSource.returnResource(jedis);
        }
    }

    public String hget(String key, String subkey) {
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
            return jedis.hget(key, subkey);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            redisDateSource.returnResource(jedis);
        }
    }

    public void hset(String key, String field, String value) {
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
            jedis.hset(key, field, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            redisDateSource.returnResource(jedis);
        }
    }

    public Long hdel(String key, String member) {
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
            return jedis.hdel(key, member);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            redisDateSource.returnResource(jedis);
        }
    }

    public void hmset(String key, Map<String, String> map) {
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
            jedis.hmset(key, map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            redisDateSource.returnResource(jedis);
        }
    }

    public List<String> hmget(String key, String[] strs) {
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
            return jedis.hmget(key, strs);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            redisDateSource.returnResource(jedis);
        }
    }

    /***************************************************************
     ***********************      Set 4       ***********************
     ***************************************************************/

    /***************************************************************
     ***********************      ZSet        **********************
     ***************************************************************/

    /***************************************************************
     ***********************      List        ***********************
     ***************************************************************/

//         .    many methods
//         .
//         .
//         .
//         .
//         .

    public static void main(String[] args) {
        ApplicationContext con = new ClassPathXmlApplicationContext("applicationContext.xml");
        SingleCore core = con.getBean(SingleCore.class);

//		core.setex("user:1", "shangmingtao",60);
//		System.out.println(core.exists("user:1"));
//		System.out.println(core.get("user:1"));
//		System.out.println(core.del("user:1"));

//		core.hset("user:1", "name", "shangmingtao");
//		core.hset("user:1", "sex", "man");
//		core.hset("user:1", "age", "25");
//		System.out.println(core.hgetall("user:1"));
//		core.hdel("user:1", "name");
//		System.out.println(core.hgetall("user:1"));
//		System.out.println(core.expire("user:1",15));
        Map<String,String> map = new HashMap<String, String>();
        map.put("name", "shangmingtao");
        map.put("sex", "man");
        map.put("age", "25");
        core.hmset("user:1", map);
        System.out.println(core.hgetall("user:1"));
        String[] strs = new String[]{"name","sex","aaaa"};
        System.out.println(core.hmget("user:1", strs));
        System.out.println(core.exists("user:12"));
    }
}
