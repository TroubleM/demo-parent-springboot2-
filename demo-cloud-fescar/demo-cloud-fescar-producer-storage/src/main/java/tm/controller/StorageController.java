package tm.controller;

import com.alibaba.fescar.core.context.RootContext;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tm.service.spi.StorageService;

import java.util.Map;

@RestController
@RequestMapping(value = "storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    private static final Logger LOGGER  = LoggerFactory.getLogger(StorageController.class);

    @RequestMapping(value = "deduct")
    public Object deduct(String commodityCode, int count, String code) {

        LOGGER.info("Order Service Begin ... xid: " + RootContext.getXID());

        storageService.deduct(commodityCode,count);

        Map<String,Object> resultMap = Maps.newHashMap();

        resultMap.put("code","200");

        resultMap.put("message","操作成功");

        //当命令code为0时，休眠30秒，可以看到数据库局部数据源事务已提交
        if(code.equals("0")){
            try {
                Thread.sleep(30000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return resultMap;
    }

}
