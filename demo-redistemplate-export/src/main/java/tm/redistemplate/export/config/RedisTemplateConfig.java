package tm.redistemplate.export.config;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import tm.redistemplate.export.disconf.param.RedisTemplateExportParam;

@Configuration
public class RedisTemplateConfig {

    private static final Logger logger = LoggerFactory.getLogger(RedisTemplateConfig.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisTemplateExportParam redisTemplateExportParam;

    @Bean
    public RedisTemplate redisTemplate() throws Exception {
        System.out.println(redisTemplateExportParam.getKeySerializer());
        System.out.println(redisTemplateExportParam.getHashKeySerializer());
        logger.info("拓展设置RedisTemplate的key序列化方式");
        if(StringUtils.isNotEmpty(redisTemplateExportParam.getKeySerializer())){
            redisTemplate.setKeySerializer((RedisSerializer)Class.forName(
                    redisTemplateExportParam.getKeySerializer()).newInstance());
        }if(StringUtils.isNotEmpty(redisTemplateExportParam.getHashKeySerializer())){
            redisTemplate.setHashValueSerializer((RedisSerializer)Class.forName(
                    redisTemplateExportParam.getHashKeySerializer()).newInstance());
        }
        return redisTemplate;
    }

}
