package tm.redistemplate.export.disconf.param;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import org.springframework.stereotype.Component;

@Component
@DisconfFile(filename = "redis-export-application.properties")
public class RedisTemplateExportParam {

    /**
     * @auther: zhangyi
     * @date: 2019/7/16
     * @Description: K-V数据结构key的序列化类的全类名
     */
    private String keySerializer;

    /**
     * @auther: zhangyi
     * @date: 2019/7/16
     * @Description: Hash数据结构key的序列化类的全类名
     */
    private String hashKeySerializer;

    @DisconfFileItem(name = "key.serializer",associateField = "keySerializer")
    public String getKeySerializer() {
        return keySerializer;
    }

    public void setKeySerializer(String keySerializer) {
        this.keySerializer = keySerializer;
    }

    @DisconfFileItem(name = "hash.key.serializer",associateField = "hashKeySerializer")
    public String getHashKeySerializer() {
        return hashKeySerializer;
    }

    public void setHashKeySerializer(String hashKeySerializer) {
        this.hashKeySerializer = hashKeySerializer;
    }
}
