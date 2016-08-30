package com.my.redis.config;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import redis.clients.jedis.HostAndPort;

import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * Created by mac on 16/8/26.
 * @author Milo.S
 * @version 1.0.0
 */
@Service
public class RedisConfig {

    Logger log = Logger.getLogger(RedisConfig.class);

    private ResourceBundle resourceBundle;

    /*
    池配置,用Integer因为如果出现异常可以捕获空指针,如果用基本数据类型虽然性能更好,但这个类只在加载时构建一次。
     */
    private Integer maxTotal = null;
    private Integer maxIdle = null;
    private Integer maxWaitMillis = null;
    private Boolean testOnBorrow = null;
    private Boolean testOnReturn = null;

    /*
    单实例配置
     */
    private String Host = null;
    private Integer Port  = null;
    private Integer TimeOut = null;
    private String Password = null;

    /*
    集群配置
     */
    private Set<HostAndPort> set = new HashSet<HostAndPort>();
    private Integer connectionTimeout = null;
    private Integer soTimeout = null;
    private Integer maxAttempts = null;
    private String clusterPassword = null;


    /*
    构造方法
     */
    private RedisConfig(){
        if (resourceBundle == null){
            resourceBundle = ResourceBundle.getBundle("redis");
            if (resourceBundle != null){
                if(!StringUtils.isEmpty(resourceBundle.getString("redis.model"))) {
                    if (!StringUtils.isEmpty(resourceBundle.getString("redis.pool.maxTotle"))) {
                        this.maxTotal = Integer.parseInt(resourceBundle.getString("redis.pool.maxTotle"));
                    }
                    if (!StringUtils.isEmpty(resourceBundle.getString("redis.pool.maxIdle"))) {
                        this.maxIdle = Integer.parseInt(resourceBundle.getString("redis.pool.maxIdle"));
                    }
                    if (!StringUtils.isEmpty(resourceBundle.getString("redis.pool.maxWaitMillis"))) {
                        this.maxWaitMillis = Integer.parseInt(resourceBundle.getString("redis.pool.maxWaitMillis"));
                    }
                    if (!StringUtils.isEmpty(resourceBundle.getString("redis.pool.testOnBorrow"))) {
                        this.testOnBorrow = Boolean.valueOf(resourceBundle.getString("redis.pool.testOnBorrow"));
                    }

                    if (!StringUtils.isEmpty(resourceBundle.getString("redis.pool.testOnReturn"))) {
                        this.testOnReturn = Boolean.valueOf(resourceBundle.getString("redis.pool.testOnReturn"));
                    }
                    String model = resourceBundle.getString("redis.model");
                    if("single".equals(model)) {
                        //单实例redis配置项
                        if (!StringUtils.isEmpty(resourceBundle.getString("redis.Host"))) {
                            this.Host = resourceBundle.getString("redis.Host");
                        }
                        if (!StringUtils.isEmpty(resourceBundle.getString("redis.Port"))) {
                            this.Port = Integer.parseInt(resourceBundle.getString("redis.Port"));
                        }
                        if (!StringUtils.isEmpty(resourceBundle.getString("redis.TimeOut"))) {
                            this.TimeOut = Integer.parseInt(resourceBundle.getString("redis.TimeOut"));
                        }
                        if (!StringUtils.isEmpty(resourceBundle.getString("redis.Password"))) {
                            this.Password = resourceBundle.getString("redis.Password");
                        }
                        log.info("======redis init success ,now model : single 。======");
                    }
                    if("cluster".equals(model)){
                        //集群配置项
                        for (int i = 1; i < 4 ; i++) {
                            if (!StringUtils.isEmpty(resourceBundle.getString("redis.Master.Host"+i))&&
                                    !StringUtils.isEmpty(resourceBundle.getString("redis.Master.Post"+i))&&
                                    !StringUtils.isEmpty(resourceBundle.getString("redis.Slave.Host"+i))&&
                                    !StringUtils.isEmpty(resourceBundle.getString("redis.Slave.Post"+i))) {
                                log.info(resourceBundle.getString("redis.Master.Host"+i));
                                log.info(resourceBundle.getString("redis.Master.Post"+i));
                                log.info(resourceBundle.getString("redis.Slave.Host"+i));
                                log.info(resourceBundle.getString("redis.Slave.Post"+i));
                                this.set.add(new HostAndPort(resourceBundle.getString("redis.Master.Host"+i),Integer.parseInt(resourceBundle.getString("redis.Master.Post"+i))));
                                this.set.add(new HostAndPort(resourceBundle.getString("redis.Slave.Host"+i),Integer.parseInt(resourceBundle.getString("redis.Slave.Post"+i))));
                            }
                        }
                        if (!StringUtils.isEmpty(resourceBundle.getString("redis.connectionTimeout"))) {
                            this.connectionTimeout = Integer.parseInt(resourceBundle.getString("redis.connectionTimeout"));
                        }
                        if (!StringUtils.isEmpty(resourceBundle.getString("redis.soTimeout"))) {
                            this.soTimeout = Integer.parseInt(resourceBundle.getString("redis.soTimeout"));
                        }
                        if (!StringUtils.isEmpty(resourceBundle.getString("redis.maxAttempts"))) {
                            this.maxAttempts = Integer.parseInt(resourceBundle.getString("redis.maxAttempts"));
                        }
                        if (!StringUtils.isEmpty(resourceBundle.getString("redis.clusterPassword"))) {
                            this.clusterPassword = resourceBundle.getString("redis.clusterPassword");
                        }
                        log.info("======redis init success ,now model : cluster 。======");
                    }
                    if(!"single".equals(model) && !"cluster".equals(model)){
                        log.info("======redis failed ,case by : unknow model======");
                        throw new RuntimeException("unknow model of redis");
                    }
                }

            }
        }
    }


    public Integer getMaxTotal() {
        return maxTotal;
    }

    public Integer getMaxIdle() {
        return maxIdle;
    }

    public Integer getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public Boolean getTestOnBorrow() {
        return testOnBorrow;
    }

    public Boolean getTestOnReturn() {
        return testOnReturn;
    }

    public String getHost() {
        return Host;
    }

    public Integer getPort() {
        return Port;
    }

    public Integer getTimeOut() {
        return TimeOut;
    }

    public String getPassword() {
        return Password;
    }

    public Set<HostAndPort> getSet() {
        return set;
    }

    public Integer getConnectionTimeout() {
        return connectionTimeout;
    }

    public Integer getSoTimeout() {
        return soTimeout;
    }

    public Integer getMaxAttempts() {
        return maxAttempts;
    }

    public String getClusterPassword() {
        return clusterPassword;
    }
}
