package cn.lhzh.springbootredismasterslave.webapi.service;

import cn.lhzh.springbootredismasterslave.utils.RedisUtils;
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
    private RedisUtils redisUtils;

    @Override
    public Map<Object, Object> getTest(HttpServletRequest request,String key,String value) {
        Map<Object,Object>map = new HashMap<>();
        // 主机写
        boolean setRes = redisUtils.set(key, value);
        // 从机读
        String getContent = redisUtils.get(key).toString();
        map.put("value",getContent);
        return map;
    }
}
