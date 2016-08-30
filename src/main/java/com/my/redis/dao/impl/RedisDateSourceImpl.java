package com.my.redis.dao.impl;

import com.my.redis.config.RedisConfig;
import com.my.redis.dao.RedisDataSource;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.*;

import java.util.Set;

/**
 * Created by mac on 16/8/26.
 * @author Milo.S
 * @version 1.0.0
 */
@Service
public class RedisDateSourceImpl implements RedisDataSource {

    @Autowired
    private RedisConfig redisConfig;

    private JedisPool jedisPool;

    private JedisCluster jedisCluster;

    public Jedis getRedisClientForSingleServer() {
        try {
            if( jedisPool == null ){
                JedisPoolConfig config = new JedisPoolConfig();
                config.setMaxTotal(redisConfig.getMaxTotal());
                config.setMaxIdle(redisConfig.getMaxIdle());
                config.setMaxWaitMillis(redisConfig.getMaxWaitMillis());
                config.setTestOnBorrow(redisConfig.getTestOnBorrow());
                config.setTestOnReturn(redisConfig.getTestOnReturn());
                String Host = redisConfig.getHost();
                Integer Port = redisConfig.getPort() ;
                Integer TimeOut = redisConfig.getTimeOut();
                String Password = redisConfig.getPassword();
                jedisPool = new JedisPool(config , Host , Port , TimeOut , Password);
//             通过spring获取对
//             ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//             jedisPool = (JedisPool) context.getBean("jedisPool");
            }
            return jedisPool.getResource();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public JedisCluster getRedisClientForClusterServer(){
        try {
          if (jedisCluster == null){
              GenericObjectPoolConfig config = new GenericObjectPoolConfig();
              config.setMaxTotal(redisConfig.getMaxTotal());
              config.setMaxIdle(redisConfig.getMaxIdle());
              config.setMaxWaitMillis(redisConfig.getMaxWaitMillis());
              config.setTestOnBorrow(redisConfig.getTestOnBorrow());
              config.setTestOnReturn(redisConfig.getTestOnReturn());
              Set<HostAndPort> set = redisConfig.getSet();
              Integer connectionTimeout = redisConfig.getConnectionTimeout();
              Integer soTimeout = redisConfig.getSoTimeout();
              Integer maxAttempts = redisConfig.getMaxAttempts();
              String clusterPassword = redisConfig.getClusterPassword(); //集群密码没有设置,还具体看咋设置
              jedisCluster = new JedisCluster(set,connectionTimeout,soTimeout,maxAttempts,config);
          }
          return jedisCluster;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void returnResource(Jedis jedis) {
        try {
            if (jedis != null) {
                jedis.close();
            }else{
                throw new RuntimeException("释放jedis连接异常,jedis对象为空");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
