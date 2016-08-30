package com.my.redis.service;

import com.my.redis.core.ClusterCore;
import com.my.redis.core.SingleCore;
import com.my.redis.vo.RedisResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mac on 16/8/30.
 * @author Milo.S
 * @version 1.0.0
 * @ps: 如果是单实例模式或者集群模式,只需将其中一个注入注释掉就可以了
 *      但是要特别注意,如果是集群模式,很多单实例的方法不支持。
 */
@Service
public class JedisService {

//    @Autowired
//    private SingleCore Core;
    @Autowired
    private ClusterCore Core;

    /*
    demo:设置 key: user:1 的 value: shangmingtao
         然后取出并返回
     */
    public RedisResultVo<String> demo(String id ,String name){
        RedisResultVo<String> vo = new RedisResultVo<String>();
        Core.set("user:"+id , name);
        String resultName = Core.get("user:"+id);
        if (resultName != null){
            vo.setObj(resultName);
            return vo;
        }else{
            vo.setErrorFlag(false);
            vo.setMsg("没有查到这个用户");
            return vo;
        }
    }
}
