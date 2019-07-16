package tm.disconf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import tm.disconf.param.DisconfDemoParam;

@Configuration
public class RedisTemplateConfig{

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private DisconfDemoParam disconfDemoParam;

    @Bean
    public RedisTemplate redisTemplate() throws Exception {
        redisTemplate.setKeySerializer((RedisSerializer)Class.forName(
                disconfDemoParam.getKeySerializer()).newInstance());
        redisTemplate.setHashValueSerializer((RedisSerializer)Class.forName(
                disconfDemoParam.getHashKeySerializer()).newInstance());
        return redisTemplate;
    }

}
