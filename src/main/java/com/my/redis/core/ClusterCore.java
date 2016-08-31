package com.my.redis.core;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.my.redis.dao.impl.RedisDateSourceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.Tuple;

/**
 * Created by mac on 16/8/30.
 * @author Milo.S
 * @version 1.0.0
 */
@Service
public class ClusterCore {
    @Autowired
    private RedisDateSourceImpl redisDateSource;


	/***************************************************************
     ***********************  key and String ***********************
     ***************************************************************/
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

    public void set(String key , String value){
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = redisDateSource.getRedisClientForClusterServer();
            jedisCluster.set(key, value);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Boolean exists(String key){
	    JedisCluster jedisCluster = null;
	    try {
	        jedisCluster = redisDateSource.getRedisClientForClusterServer();
	        return jedisCluster.exists(key);
	    }catch (Exception e){
	        e.printStackTrace();
	        return null;
	    }
	}

	public void setex(String key, String value, int seconds){
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = redisDateSource.getRedisClientForClusterServer();
            jedisCluster.setex(key, seconds, value);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Long expire(String key ,int sec){
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = redisDateSource.getRedisClientForClusterServer();
            return jedisCluster.expire(key, sec);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Long del(String key){
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = redisDateSource.getRedisClientForClusterServer();
            return jedisCluster.del(key);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String hget(String key, String subkey) {
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = redisDateSource.getRedisClientForClusterServer();
            return jedisCluster.hget(key, subkey);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void hset(String key, String field, String value) {
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = redisDateSource.getRedisClientForClusterServer();
            jedisCluster.hset(key, field, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Long hdel(String key, String member) {
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = redisDateSource.getRedisClientForClusterServer();
            return jedisCluster.hdel(key, member);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void hmset(String key, Map<String, String> map) {
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = redisDateSource.getRedisClientForClusterServer();
            jedisCluster.hmset(key, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> hmget(String key, String[] strs) {
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = redisDateSource.getRedisClientForClusterServer();
            return jedisCluster.hmget(key, strs);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /***************************************************************
	 ***********************      Hash       ***********************
	 ***************************************************************/
	
	public Map<String, String> hgetall(String cid) {
	    JedisCluster jedisCluster = null;
	    try {
	        jedisCluster = redisDateSource.getRedisClientForClusterServer();
	        return jedisCluster.hgetAll(cid);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	/***************************************************************
     ***********************      Set        ***********************
     ***************************************************************/
    public void sadd(String key, String[] mems) {
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = redisDateSource.getRedisClientForClusterServer();
            jedisCluster.sadd(key,mems);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean sismember(String key, String mem) { //mem是否存在于set中
	    JedisCluster jedisCluster = null;
	    try {
	        jedisCluster = redisDateSource.getRedisClientForClusterServer();
	        return jedisCluster.sismember(key,mem);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	public Set<String> smembers(String key) { //取出所有
	    JedisCluster jedisCluster = null;
	    try {
	        jedisCluster = redisDateSource.getRedisClientForClusterServer();
	        return jedisCluster.smembers(key);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	public Long srem(String key, String[] mems) { //删除
	    JedisCluster jedisCluster = null;
	    try {
	        jedisCluster = redisDateSource.getRedisClientForClusterServer();
	        return jedisCluster.srem(key , mems);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	public Long scard(String key) { //获取set个数
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = redisDateSource.getRedisClientForClusterServer();
            return jedisCluster.scard(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /***************************************************************
     ***********************      ZSet        ***********************
     ***************************************************************/

    public void zadd(String key , Double score , String value) {
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = redisDateSource.getRedisClientForClusterServer();
            jedisCluster.zadd(key , score , value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void zadd(String key , Map<String , Double> map ) {
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = redisDateSource.getRedisClientForClusterServer();
            jedisCluster.zadd(key , map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*
		删除
	 */
	public void zrem(String key , String[] mems) {
	    JedisCluster jedisCluster = null;
	    try {
	        jedisCluster = redisDateSource.getRedisClientForClusterServer();
	        jedisCluster.zrem(key , mems);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	/*
		是否存在
	 */
	public Boolean zsismember(String key , String value) {
	    JedisCluster jedisCluster = null;
	    try {
	        jedisCluster = redisDateSource.getRedisClientForClusterServer();
	        if(jedisCluster.zscore(key , value) != null){
	        	return true;
	        }else{
	        	return false;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	/*
		取出分值
	 */
	public Double zscore(String key , String value) {
	    JedisCluster jedisCluster = null;
	    try {
	        jedisCluster = redisDateSource.getRedisClientForClusterServer();
	        return jedisCluster.zscore(key , value);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
    /*
    	数量
     */
    public Long zcard(String key) {
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = redisDateSource.getRedisClientForClusterServer();
            return jedisCluster.zcard(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
    	分数范围数量
     */
    public Long zcount(String key , Double min ,Double max) {
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = redisDateSource.getRedisClientForClusterServer();
            return jedisCluster.zcount(key , min , max);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
   		根据分值正序排序 , 根据下标取 
     */
    public Set<String> zrange(String key , Long start , Long stop) {
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = redisDateSource.getRedisClientForClusterServer();
            return jedisCluster.zrange(key , start , stop);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /*
		根据分值倒序排序 , 根据下标取 
	 */
	public Set<String> zrevrange(String key , Long start , Long stop) {
	    JedisCluster jedisCluster = null;
	    try {
	        jedisCluster = redisDateSource.getRedisClientForClusterServer();
	        return jedisCluster.zrevrange(key , start , stop);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
    
    /*
    	根据分值正序排序 , 根据分值范围取
     */
    public Set<String> zrangeByScore(String key , Double min , Double max) {
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = redisDateSource.getRedisClientForClusterServer();
            return jedisCluster.zrangeByScore(key , min , max);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /*
    	根据分值正序排序 , 根据分值范围取
     */
    public Set<String> zrangeByScore(String key , Double min , Double max , int offset , int count) {
    	JedisCluster jedisCluster = null;
    	try {
    		jedisCluster = redisDateSource.getRedisClientForClusterServer();
    		return jedisCluster.zrangeByScore(key , min , max , offset , count);
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
    /*
		根据分值正序排序 , 根据分值范围取
	 */
	public Set<String> zrevrangeByScore(String key , Double min , Double max) {
	    JedisCluster jedisCluster = null;
	    try {
	        jedisCluster = redisDateSource.getRedisClientForClusterServer();
	        return jedisCluster.zrevrangeByScore(key , min , max);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
    
	 /*
		根据分值正序排序 , 根据下标取 值和分值
	 */
	public Set<Tuple> zrangeWithScores(String key , Long start , Long stop) {
	    JedisCluster jedisCluster = null;
	    try {
	        jedisCluster = redisDateSource.getRedisClientForClusterServer();
	        return jedisCluster.zrangeWithScores(key , start , stop);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	/*
		根据分值倒序排序 , 根据下标取 值和分值
	 */
	public Set<Tuple> zrevrangeWithScores(String key , Long start , Long stop) {
	    JedisCluster jedisCluster = null;
	    try {
	        jedisCluster = redisDateSource.getRedisClientForClusterServer();
	        return jedisCluster.zrevrangeWithScores(key , start , stop);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	/*
		根据分值正序排序 , 根据分值范围取 值和分值
	 */
	public Set<Tuple> zrangeByScoreWithScores(String key , Double min , Double max) {
	    JedisCluster jedisCluster = null;
	    try {
	        jedisCluster = redisDateSource.getRedisClientForClusterServer();
	        return jedisCluster.zrangeByScoreWithScores(key , min , max);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	/*
		根据分值正序排序 , 根据分值范围取 值和分值
	 */
	public Set<Tuple> zrevrangeByScoreWithScores(String key , Double min , Double max) {
	    JedisCluster jedisCluster = null;
	    try {
	        jedisCluster = redisDateSource.getRedisClientForClusterServer();
	        return jedisCluster.zrevrangeByScoreWithScores(key , min , max);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}






    /***************************************************************
     ***********************      List        **********************
     ***************************************************************/

    public void lpush(String key, String[] mems) {
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = redisDateSource.getRedisClientForClusterServer();
            jedisCluster.lpush(key , mems);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rpush(String key, String[] mems) {
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = redisDateSource.getRedisClientForClusterServer();
            jedisCluster.rpush(key , mems);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<String> lrange(String key, Long start , Long end) {
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = redisDateSource.getRedisClientForClusterServer();
            return jedisCluster.lrange(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
		根据坐标获取
	    0     第一个     1  第二个
	   -1     最后一个  -2  倒数第二个
	 */
	public String lindex(String key , int num ) {
	    JedisCluster jedisCluster = null;
	    try {
	        jedisCluster = redisDateSource.getRedisClientForClusterServer();
	        return jedisCluster.lindex(key , num);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	public Long llen(String key) { //长度
	    JedisCluster jedisCluster = null;
	    try {
	        jedisCluster = redisDateSource.getRedisClientForClusterServer();
	        return jedisCluster.llen(key);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	/*
	     count > 0: 从头往尾移除值为 value 的元素。
	     count < 0: 从尾往头移除值为 value 的元素。
	     count = 0: 移除所有值为 value 的元素。
	     count -2 从尾往头移除两个
	  */
	public Long lrem(String key , int count , String value) {
	    JedisCluster jedisCluster = null;
	    try {
	        jedisCluster = redisDateSource.getRedisClientForClusterServer();
	        return jedisCluster.lrem(key , count , value);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	public String lpop(String key) {
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = redisDateSource.getRedisClientForClusterServer();
            return jedisCluster.lpop(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String rpop(String key) {
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = redisDateSource.getRedisClientForClusterServer();
            return jedisCluster.rpop(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
	     set
	     0     第一个 1 第二个
	     -1  最后一个  -2 倒数第二个
   */
    public void lset(String key , Long num , String value) {
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = redisDateSource.getRedisClientForClusterServer();
            jedisCluster.lset(key, num ,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    	截取sublist
	    0     第一个     1  第二个
	   -1     最后一个  -2  倒数第二个
     */
    public void ltrim(String key , int start , int end) {
        JedisCluster jedisCluster = null;
        try {
            jedisCluster = redisDateSource.getRedisClientForClusterServer();
            jedisCluster.ltrim(key, start ,end);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   

}
