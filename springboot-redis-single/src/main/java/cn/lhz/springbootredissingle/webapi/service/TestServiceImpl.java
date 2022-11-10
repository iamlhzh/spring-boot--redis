package cn.lhz.springbootredissingle.webapi.service;

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

    @Override
    public Map<String, Object> getTest(HttpServletRequest request) {
        Map<String,Object>map = new HashMap<>();
        map.put("RemoteAddr",request.getRemoteAddr());
        map.put("RemoteHost",request.getRemoteHost());
        return map;
    }
}
