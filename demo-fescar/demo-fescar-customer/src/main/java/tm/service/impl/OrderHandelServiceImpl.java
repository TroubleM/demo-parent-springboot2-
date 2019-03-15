package tm.service.impl;

import com.alibaba.fescar.core.context.RootContext;
import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tm.bean.OrderResponse;
import tm.service.OrderHandelService;
import tm.service.OrderService;
import tm.service.StorageService;

@Service
@Transactional
public class OrderHandelServiceImpl implements OrderHandelService {

    private Logger LOGGER = LoggerFactory.getLogger(OrderHandelServiceImpl.class);

    @Autowired
    private StorageService storageService;

    @Autowired
    private OrderService orderService;

    @Override
    @GlobalTransactional(timeoutMills = 600000, name = "dubbo-demo-tx")
    public OrderResponse handelOrder(String userId, String commodityCode, Integer orderCount,
                                     String code) {

        LOGGER.info("xid==============={}", RootContext.getXID());

        OrderResponse orderResponse = orderService.
                create(userId,commodityCode,orderCount);
        storageService.deduct(commodityCode,orderCount);

        if("-1".equals(code)){
            LOGGER.error("手动执行运行时异常");
            System.out.println(1/0);
        }

        return orderResponse;
    }
}
