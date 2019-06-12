package tm.disconf.param;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import org.springframework.stereotype.Component;

/**
 * @auther: zhangyi
 * @date: 2019/6/12
 * @Description: 远程关联properties配置文件类
 */
@Component
@DisconfFile(filename = "disconf-demo-application.properties")
public class DisconfDemoParam {

    private String username;

    private String password;

    @DisconfFileItem(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @DisconfFileItem(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
