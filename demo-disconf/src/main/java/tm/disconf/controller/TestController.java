package tm.disconf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tm.disconf.config.TestConfig;
import tm.disconf.param.DisconfDemoParam;

@RestController
@RequestMapping(value = "test")
public class TestController {

    @Autowired
    private TestConfig testConfig;

    @Autowired
    private DisconfDemoParam disconfDemoParam;

    @GetMapping(value = "test1")
    public Object test1(){
        System.out.println(testConfig.getUsername());
        System.out.println(testConfig.getPassword());
        System.out.println(disconfDemoParam.getUsername());
        System.out.println(disconfDemoParam.getPassword());
        return "使用Value注解引入远程配置---" + testConfig.getUsername() +
                "===使用Disconf相关注解引入远程配置" + disconfDemoParam.getUsername();
    }

}
