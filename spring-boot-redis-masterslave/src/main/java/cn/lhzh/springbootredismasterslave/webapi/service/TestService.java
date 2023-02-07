package cn.lhzh.springbootredismasterslave.webapi.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author 卢宏政
 * @date 2022/11/4 16:05
 */
public interface TestService {
    Map<Object, Object> getTest(HttpServletRequest request,String key,String value);
}
