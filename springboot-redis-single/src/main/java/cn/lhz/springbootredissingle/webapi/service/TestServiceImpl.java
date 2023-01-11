package cn.lhz.springbootredissingle.webapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
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

    @Override
    public Map<String, Object> getTest(HttpServletRequest request) {
        Map<String,Object>map = new HashMap<>();
        map.put("RemoteAddr",request.getRemoteAddr());
        map.put("RemoteHost",request.getRemoteHost());
        Boolean a = redisTemplate.hasKey("a");
        Set keys = redisTemplate.keys("*");
        ValueOperations valueOperations = redisTemplate.opsForValue();
        return map;
    }
}
