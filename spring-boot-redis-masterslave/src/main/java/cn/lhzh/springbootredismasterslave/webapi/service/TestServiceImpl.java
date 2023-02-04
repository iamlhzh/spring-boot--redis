package cn.lhzh.springbootredismasterslave.webapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 卢宏政
 * @date 2022/11/4 16:05
 */
@Service
public class TestServiceImpl implements TestService {
    
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Map<Object, Object> getTest(HttpServletRequest request) {
        Map<Object,Object>map = new HashMap<>();
        map.put("RemoteAddr",request.getRemoteAddr());
        map.put("RemoteHost",request.getRemoteHost());
        Boolean a = redisTemplate.hasKey("a");
        Set keys = redisTemplate.keys("*");
        System.out.println(a);
        System.out.println(keys);
        map.put("keys",keys);
        return map;
    }
}
