package tm.disconf.param;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@DisconfFile(filename = "disconf-demo-redis-string-key.properties")
public class RedisStringKeyParam {

    private List<String> of;

    @DisconfFileItem(name = "of")
    public List<String> getOf() {
        return of;
    }

    public void setOf(List<String> of) {
        this.of = of;
    }
}
