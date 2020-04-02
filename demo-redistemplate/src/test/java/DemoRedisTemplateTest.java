import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import tm.Application;
import tm.service.DemoAopService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DemoRedisTemplateTest {

    @Autowired
    private RedisTemplate<String, String> stringForRedisTemplate;

    @Autowired
    private RedisTemplate <Object, Object> objectRedisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private DemoAopService demoAopService;

    @Test
    public void test1(){
        System.out.println(stringForRedisTemplate);
        System.out.println(objectRedisTemplate);
        System.out.println(stringRedisTemplate);
    }

    @Test
    public void test2(){
        stringRedisTemplate.delete("3");
        stringRedisTemplate.opsForValue().set("3","1");

        System.out.println(stringForRedisTemplate.opsForValue().get("3"));
        stringForRedisTemplate.setKeySerializer(new StringRedisSerializer());
        stringForRedisTemplate.setValueSerializer(new StringRedisSerializer());
        System.out.println(stringForRedisTemplate.opsForValue().get("3"));
    }

    @Test
    public void test3(){
        objectRedisTemplate.delete("1");
        System.out.println(objectRedisTemplate.opsForList().leftPush("1","1"));

        stringRedisTemplate.opsForValue().set("8","8");
        stringRedisTemplate.opsForValue().get("8");
    }

    @Test
    public void test4(){
        try {
            demoAopService.test2();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
