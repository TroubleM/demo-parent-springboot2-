package tm.redistemplate.export.callback;

import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import tm.redistemplate.export.disconf.param.RedisTemplateExportParam;

@Service
@DisconfUpdateService(classes = { RedisTemplateExportParam.class})
public class RedisTemplateConfigCallBack implements IDisconfUpdate {

    private static final Logger logger = LoggerFactory.getLogger(RedisTemplateConfigCallBack.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisTemplateExportParam redisTemplateExportParam;

    @Override
    public void reload() throws Exception {
        logger.info("更新RedisTemplate的key序列化方式");
        if(StringUtils.isNotEmpty(redisTemplateExportParam.getKeySerializer())){
            redisTemplate.setKeySerializer((RedisSerializer)Class.forName(
                    redisTemplateExportParam.getKeySerializer()).newInstance());
        }if(StringUtils.isNotEmpty(redisTemplateExportParam.getHashKeySerializer())){
            redisTemplate.setHashValueSerializer((RedisSerializer)Class.forName(
                    redisTemplateExportParam.getHashKeySerializer()).newInstance());
        }


    }
}
