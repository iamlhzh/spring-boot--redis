package cn.lhzh.springbootredisclusterautoswitch.webapi.service;


import java.util.Map;

/**
 * @author 卢宏政
 * @date 2022/11/4 16:05
 */
public interface TestService {
    Map<Object, Object> getTest(String key);

    Map<Object, Object> setTest(String key, String value);
}
