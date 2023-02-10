package cn.lhzh.springbootredissentinel.webapi.service;


import cn.lhzh.springbootredissentinel.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 卢宏政
 * @date 2022/11/4 16:05
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public Map<Object, Object> getTest(String key) {
        Map<Object,Object> map = new HashMap<>();
        // 从机读
        Object getContent = redisUtils.get(key);
        map.put(key,getContent);
        return map;
    }

    @Override
    public Map<Object, Object> setTest(String key, String value) {
        Map<Object,Object> map = new HashMap<>();
        boolean set = redisUtils.set(key, value);
        map.put("result",set);
        return map;
    }
}
