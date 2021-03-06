package com.my.redis.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import com.my.redis.dao.impl.RedisDateSourceImpl;

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

    public void set(String key , String value){
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
            jedis.set(key, value);
        }catch (Exception e){
            e.printStackTrace();
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

	/***************************************************************
     ***********************      Set        ***********************
     ***************************************************************/
    public void sadd(String key, String[] mems) {
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
            jedis.sadd(key,mems);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            redisDateSource.returnResource(jedis);
        }
    }

    public Boolean sismember(String key, String mem) { //mem是否存在于set中
	    Jedis jedis = null;
	    try {
	        jedis = redisDateSource.getRedisClientForSingleServer();
	        return jedis.sismember(key,mem);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        redisDateSource.returnResource(jedis);
	    }
	}

	public Set<String> smembers(String key) { //取出所有
	    Jedis jedis = null;
	    try {
	        jedis = redisDateSource.getRedisClientForSingleServer();
	        return jedis.smembers(key);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        redisDateSource.returnResource(jedis);
	    }
	}

	public Long srem(String key, String[] mems) { //删除
	    Jedis jedis = null;
	    try {
	        jedis = redisDateSource.getRedisClientForSingleServer();
	        return jedis.srem(key , mems);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        redisDateSource.returnResource(jedis);
	    }
	}

	public Long scard(String key) { //获取set个数
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
            return jedis.scard(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            redisDateSource.returnResource(jedis);
        }
    }

    /***************************************************************
     ***********************      ZSet        ***********************
     ***************************************************************/

    public void zadd(String key , Double score , String value) {
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
            jedis.zadd(key , score , value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            redisDateSource.returnResource(jedis);
        }
    }

    public void zadd(String key , Map<String , Double> map ) {
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
            jedis.zadd(key , map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            redisDateSource.returnResource(jedis);
        }
    }
    
    /*
		删除
	 */
	public void zrem(String key , String[] mems) {
	    Jedis jedis = null;
	    try {
	        jedis = redisDateSource.getRedisClientForSingleServer();
	        jedis.zrem(key , mems);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        redisDateSource.returnResource(jedis);
	    }
	}

	/*
		是否存在
	 */
	public Boolean zsismember(String key , String value) {
	    Jedis jedis = null;
	    try {
	        jedis = redisDateSource.getRedisClientForSingleServer();
	        if(jedis.zscore(key , value) != null){
	        	return true;
	        }else{
	        	return false;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        redisDateSource.returnResource(jedis);
	    }
	}

	/*
		取出分值
	 */
	public Double zscore(String key , String value) {
	    Jedis jedis = null;
	    try {
	        jedis = redisDateSource.getRedisClientForSingleServer();
	        return jedis.zscore(key , value);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        redisDateSource.returnResource(jedis);
	    }
	}
	
    /*
    	数量
     */
    public Long zcard(String key) {
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
            return jedis.zcard(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            redisDateSource.returnResource(jedis);
        }
    }

    /*
    	分数范围数量
     */
    public Long zcount(String key , Double min ,Double max) {
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
            return jedis.zcount(key , min , max);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            redisDateSource.returnResource(jedis);
        }
    }

    /*
   		根据分值正序排序 , 根据下标取 
     */
    public Set<String> zrange(String key , Long start , Long stop) {
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
            return jedis.zrange(key , start , stop);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            redisDateSource.returnResource(jedis);
        }
    }
    
    /*
		根据分值倒序排序 , 根据下标取 
	 */
	public Set<String> zrevrange(String key , Long start , Long stop) {
	    Jedis jedis = null;
	    try {
	        jedis = redisDateSource.getRedisClientForSingleServer();
	        return jedis.zrevrange(key , start , stop);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        redisDateSource.returnResource(jedis);
	    }
	}
    
    /*
    	根据分值正序排序 , 根据分值范围取
     */
    public Set<String> zrangeByScore(String key , Double min , Double max) {
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
            return jedis.zrangeByScore(key , min , max);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            redisDateSource.returnResource(jedis);
        }
    }
    
    /*
    	根据分值正序排序 , 根据分值范围取
     */
    public Set<String> zrangeByScore(String key , Double min , Double max , int offset , int count) {
    	Jedis jedis = null;
    	try {
    		jedis = redisDateSource.getRedisClientForSingleServer();
    		return jedis.zrangeByScore(key , min , max , offset , count);
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	} finally {
    		redisDateSource.returnResource(jedis);
    	}
    }
    
    /*
		根据分值正序排序 , 根据分值范围取
	 */
	public Set<String> zrevrangeByScore(String key , Double min , Double max) {
	    Jedis jedis = null;
	    try {
	        jedis = redisDateSource.getRedisClientForSingleServer();
	        return jedis.zrevrangeByScore(key , min , max);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        redisDateSource.returnResource(jedis);
	    }
	}
    
	 /*
		根据分值正序排序 , 根据下标取 值和分值
	 */
	public Set<Tuple> zrangeWithScores(String key , Long start , Long stop) {
	    Jedis jedis = null;
	    try {
	        jedis = redisDateSource.getRedisClientForSingleServer();
	        return jedis.zrangeWithScores(key , start , stop);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        redisDateSource.returnResource(jedis);
	    }
	}
	
	/*
		根据分值倒序排序 , 根据下标取 值和分值
	 */
	public Set<Tuple> zrevrangeWithScores(String key , Long start , Long stop) {
	    Jedis jedis = null;
	    try {
	        jedis = redisDateSource.getRedisClientForSingleServer();
	        return jedis.zrevrangeWithScores(key , start , stop);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        redisDateSource.returnResource(jedis);
	    }
	}
	
	/*
		根据分值正序排序 , 根据分值范围取 值和分值
	 */
	public Set<Tuple> zrangeByScoreWithScores(String key , Double min , Double max) {
	    Jedis jedis = null;
	    try {
	        jedis = redisDateSource.getRedisClientForSingleServer();
	        return jedis.zrangeByScoreWithScores(key , min , max);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        redisDateSource.returnResource(jedis);
	    }
	}
	
	/*
		根据分值正序排序 , 根据分值范围取 值和分值
	 */
	public Set<Tuple> zrevrangeByScoreWithScores(String key , Double min , Double max) {
	    Jedis jedis = null;
	    try {
	        jedis = redisDateSource.getRedisClientForSingleServer();
	        return jedis.zrevrangeByScoreWithScores(key , min , max);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        redisDateSource.returnResource(jedis);
	    }
	}






    /***************************************************************
     ***********************      List        **********************
     ***************************************************************/

    public void lpush(String key, String[] mems) {
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
            jedis.lpush(key , mems);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            redisDateSource.returnResource(jedis);
        }
    }

    public void rpush(String key, String[] mems) {
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
            jedis.rpush(key , mems);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            redisDateSource.returnResource(jedis);
        }
    }
    
    public List<String> lrange(String key, Long start , Long end) {
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
            return jedis.lrange(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            redisDateSource.returnResource(jedis);
        }
    }

    /*
		根据坐标获取
	    0     第一个     1  第二个
	   -1     最后一个  -2  倒数第二个
	 */
	public String lindex(String key , int num ) {
	    Jedis jedis = null;
	    try {
	        jedis = redisDateSource.getRedisClientForSingleServer();
	        return jedis.lindex(key , num);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        redisDateSource.returnResource(jedis);
	    }
	}

	public Long llen(String key) { //长度
	    Jedis jedis = null;
	    try {
	        jedis = redisDateSource.getRedisClientForSingleServer();
	        return jedis.llen(key);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        redisDateSource.returnResource(jedis);
	    }
	}

	/*
	     count > 0: 从头往尾移除值为 value 的元素。
	     count < 0: 从尾往头移除值为 value 的元素。
	     count = 0: 移除所有值为 value 的元素。
	     count -2 从尾往头移除两个
	  */
	public Long lrem(String key , int count , String value) {
	    Jedis jedis = null;
	    try {
	        jedis = redisDateSource.getRedisClientForSingleServer();
	        return jedis.lrem(key , count , value);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        redisDateSource.returnResource(jedis);
	    }
	}

	public String lpop(String key) {
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
            return jedis.lpop(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            redisDateSource.returnResource(jedis);
        }
    }
    public String rpop(String key) {
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
            return jedis.rpop(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            redisDateSource.returnResource(jedis);
        }
    }

    /*
	     set
	     0     第一个 1 第二个
	     -1  最后一个  -2 倒数第二个
   */
    public void lset(String key , Long num , String value) {
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
            jedis.lset(key, num ,value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            redisDateSource.returnResource(jedis);
        }
    }

    /*
    	截取sublist
	    0     第一个     1  第二个
	   -1     最后一个  -2  倒数第二个
     */
    public void ltrim(String key , int start , int end) {
        Jedis jedis = null;
        try {
            jedis = redisDateSource.getRedisClientForSingleServer();
            jedis.ltrim(key, start ,end);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            redisDateSource.returnResource(jedis);
        }
    }


//         .    many methods
//         .
//         .
//         .
//         .
//         .

    public static void main(String[] args) {
        ApplicationContext con = new ClassPathXmlApplicationContext("applicationContext.xml");
        SingleCore core = con.getBean(SingleCore.class);
        RedisDateSourceImpl RedisDateSource = con.getBean(RedisDateSourceImpl.class);
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
//        Map<String,String> map = new HashMap<String, String>();
//        map.put("name", "shangmingtao");
//        map.put("sex", "man");
//        map.put("age", "25");
//        core.hmset("user:1", map);
//        System.out.println(core.hgetall("user:1"));
//        String[] strs = new String[]{"name","sex","aaaa"};
//        System.out.println(core.hmget("user:1", strs));
//        System.out.println(core.exists("user:12"));

//        core.sadd("set:1",new String[]{"1","2","3"});
//        System.out.println(core.scard("set:1"));
//        System.out.println(core.sismember("set:1","1"));
//        System.out.println(core.smembers("set:1"));
//        System.out.println(core.srem("set:1",new String[]{"1"}));
//        System.out.println(core.smembers("set:1"));
//        core.del("set:1"); //通过集合key方式删除,再获取这个集合时,集合内元素为空
//        System.out.println(core.smembers("set:1"));
        
        Map<String,Double> map  = new HashMap<String, Double>() ;
        map.put("a",50d);
        map.put("b",40d);
        map.put("c",30d);
        map.put("d",20d);
        map.put("e",10d);
        core.zadd("zset",map);
        System.out.println(core.zsismember("zset","a"));
        System.out.println("zrange:"+core.zrange("zset",(long)0,(long)-1));
        System.out.println("zrevrange:"+core.zrevrange("zset",(long)0,(long)-1));
        System.out.println("zrangeByScore"+core.zrangeByScore("zset",(double)10,(double)30));
        System.out.println("zrevrangeByScore"+core.zrevrangeByScore("zset",(double)30,(double)10));
        System.out.println("zrangeWithScores"+core.zrangeWithScores("zset",(long)0,(long)-1));
        System.out.println("-------------------------");
        System.out.println(core.zrangeByScore("zset",(double)10,(double)10000,1,2));
        
//        core.del("list");
//        core.lpush("list", new String[]{"1","2","3","4","5","6"});
//        core.lpop("list");
//        System.out.println(core.lrange("list", Long.valueOf(0),Long.valueOf(-1))+"    len = "+core.llen("list"));
//        System.out.println(core.lindex("list", 2));
//       core.lset("list", (long) 1, "sss");  
//       core.lset("list", (long) 2, "sss");  
//       System.out.println(core.lrange("list", Long.valueOf(0),Long.valueOf(-1))+"    len = "+core.llen("list"));
//       core.ltrim("list", 0, 2);
//       System.out.println(core.lrange("list", Long.valueOf(0),Long.valueOf(-1))+"    len = "+core.llen("list"));
//       core.lrem("list", 0, "sss");
//       System.out.println(core.lrange("list", Long.valueOf(0),Long.valueOf(-1))+"    len = "+core.llen("list"));
//       List list = new ArrayList<String>();
//       list.add("a");
//       list.add("b");
//       list.add("c");
//       System.out.println(list);
//       list.remove("a");
//        list.remove(1);
//       System.out.println(list);
//       System.out.println(list.contains("d"));
       
    }
    
}
