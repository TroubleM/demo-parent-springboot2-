package tm.disconf.callbacks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;

import tm.disconf.param.DisconfDemoParam;


/**
 * 更新配置时的回调
 */
//@Service
//@DisconfUpdateService(classes = { DisconfDemoParam.class})
public class DisconfDemoParamUpdateCallBack implements IDisconfUpdate {

    protected static final Logger LOGGER = LoggerFactory
            .getLogger(DisconfDemoParamUpdateCallBack.class);

    @Autowired
    private DisconfDemoParam disconfDemoParam;

    @Override
    public void reload() throws Exception {
        LOGGER.info("tm.disconf.param.DisconfDemoParam类修改配置" +
                disconfDemoParam.getUsername() + "--------" +
                disconfDemoParam.getPassword());
    }

}