package tm.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.duia.dubbo.bang.api.model.DuibaDubboGroupTopic;
import com.duia.dubbo.bang.api.response.ResultResponse;
import com.duia.dubbo.bang.api.service.IDuibaGroupTopicDubboService;

@Service
public class SwaggerDubboProvider implements IDuibaGroupTopicDubboService {

    @Override
    public ResultResponse<DuibaDubboGroupTopic> getLatestTopTopic(Integer sku) {
        System.out.println("消费者消费" + sku);
        return null;
    }
}
