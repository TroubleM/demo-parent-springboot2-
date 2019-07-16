package tm.disconf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tm.disconf.config.TestConfig;
import tm.disconf.param.DisconfDemoParam;
import tm.disconf.param.RedisJdkKeyParam;
import tm.disconf.param.RedisStringKeyParam;

@RestController
@RequestMapping(value = "test")
public class TestController {

    @Autowired
    private TestConfig testConfig;

    @Autowired
    private DisconfDemoParam disconfDemoParam;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisJdkKeyParam redisJdkKeyParam;

    @Autowired
    private RedisStringKeyParam redisStringKeyParam;

    @GetMapping(value = "test1")
    public Object test1(){
        System.out.println(testConfig.getUsername());
        System.out.println(testConfig.getPassword());
        System.out.println(disconfDemoParam.getUsername());
        System.out.println(disconfDemoParam.getPassword());
        return "使用Value注解引入远程配置---" + testConfig.getUsername() +
                "===使用Disconf相关注解引入远程配置" + disconfDemoParam.getUsername();
    }

    @GetMapping(value = "test2")
    public Object test2(){

        System.out.println(redisTemplate.getKeySerializer());
        System.out.println(redisTemplate.getHashKeySerializer());

        return "ok";

    }

    @GetMapping(value = "test3")
    public Object test3(){
        System.out.println(redisStringKeyParam.getOf());
        System.out.println(redisJdkKeyParam.getFs());
        return "ok";
    }

    @GetMapping(value = "test4")
    public Object test4(String key){

        redisTemplate.opsForValue().set(key,key);

        System.out.println(redisTemplate.opsForValue().get(key));
        return redisTemplate.opsForValue().get(key);
    }

}
