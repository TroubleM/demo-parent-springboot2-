package tm.disconf.callbacks;

import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import tm.disconf.param.DisconfDemoParam;

@Service
@DisconfUpdateService(classes = { DisconfDemoParam.class})
public class DisconfDemoRedisTemplateCallBack implements IDisconfUpdate {

    @Autowired
    private DisconfDemoParam disconfDemoParam;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void reload() throws Exception {
        System.out.println(disconfDemoParam.getKeySerializer());
        System.out.println(disconfDemoParam.getHashKeySerializer());
        redisTemplate.setKeySerializer((RedisSerializer)Class.forName(
                disconfDemoParam.getKeySerializer()).newInstance());
        redisTemplate.setHashValueSerializer((RedisSerializer)Class.forName(
                disconfDemoParam.getHashKeySerializer()).newInstance());
    }
}
