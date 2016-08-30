package com.my.redis.test;

import com.my.redis.config.RedisConfig;
import com.my.redis.service.JedisService;
import com.my.redis.vo.RedisResultVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mac on 16/8/30.
 */
@Controller
public class DemoTest {

    Logger log = Logger.getLogger(RedisConfig.class);

   @Autowired
    private JedisService jedisService;

    @RequestMapping("getname")
    public void test(){
        RedisResultVo<String> result = jedisService.demo("1", "shangmingtao");
        if(result.isErrorFlag()){
            //.... todo 证明返回正确
            String str = result.getObj();
            log.info(str);
        }else{
            //....
        }

        //ps: 这里只用String做了示例,如果要保存对象可以选择序列化等方式。(但是序列化多少会影响性能)
        //    hash数据结构存储今天来不及写了。
    }
}
