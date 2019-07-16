package tm.disconf.param;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@DisconfFile(filename = "disconf-demo-redis-jdk-key.properties")
public class RedisJdkKeyParam {

    private List<String> fs;

    @DisconfFileItem(name = "fs")
    public List<String> getFs() {
        return fs;
    }

    public void setFs(List<String> fs) {
        this.fs = fs;
    }
}
