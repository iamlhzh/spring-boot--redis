package cn.lhzh.springbootredisclusterlettuceauto.webapi.controller;




import cn.lhzh.springbootredisclusterlettuceauto.webapi.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/setTest", method = RequestMethod.POST)
    @ResponseBody
    public Map<Object, Object> setTest(String key,String value) {
        Map<Object, Object> map = testService.setTest(key,value);
        return map;
    }

    @RequestMapping(value = "/getTest", method = RequestMethod.POST)
    @ResponseBody
    public Map<Object, Object> getTest(String key) {
        Map<Object, Object> map = testService.getTest(key);
        return map;
    }

}
