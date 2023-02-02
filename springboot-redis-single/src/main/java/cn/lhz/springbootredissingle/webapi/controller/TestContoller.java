package cn.lhz.springbootredissingle.webapi.controller;

import cn.lhz.springbootredissingle.webapi.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Map<Object, Object> getTest(HttpServletRequest request) {
        Map<Object, Object> map = testService.getTest(request);
        return map;
    }

}
