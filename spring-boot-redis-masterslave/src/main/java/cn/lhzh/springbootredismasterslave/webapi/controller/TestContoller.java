package cn.lhzh.springbootredismasterslave.webapi.controller;


import cn.lhzh.springbootredismasterslave.webapi.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author 卢宏政
 * @date 2022/11/4 16:04
 */
@RestController
@RequestMapping("test")
public class TestContoller {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/getTest", method = RequestMethod.POST)
    @ResponseBody
    public Map<Object, Object> getTest(HttpServletRequest request,String key,String value) {
        Map<Object, Object> map = testService.getTest(request,key,value);
        return map;
    }

}
