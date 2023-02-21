package cn.lhzh.springbootredisclusterautoswitch.webapi.service;




import cn.lhzh.springbootredisclusterautoswitch.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author 卢宏政
 * @date 2022/11/4 16:05
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private RedisUtils redisUtils;

    private Logger logger = Logger.getLogger(TestServiceImpl.class.getName());

    @Override
    public Map<Object, Object> getTest(String key) {
        Map<Object,Object> map = new HashMap<>();
        // 从机读
        Object getContent = redisUtils.get(key);
        map.put(key,getContent);
        logger.info("getTest,key:"+key+",value:"+getContent);
        return map;
    }

    @Override
    public Map<Object, Object> setTest(String key, String value) {
        Map<Object,Object> map = new HashMap<>();
        boolean set = redisUtils.set(key, value);
        map.put("result",set);
        logger.info("setTest,key:"+key+",boolean:"+set);
        return map;
    }
}
