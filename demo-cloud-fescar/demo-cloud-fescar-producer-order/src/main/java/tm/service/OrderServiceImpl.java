package tm.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fescar.core.context.RootContext;

import tm.bean.Order;
import tm.bean.OrderResponse;
import tm.dao.OrderMapper;
import tm.rao.AccountRao;
import tm.service.spi.OrderService;

@SuppressWarnings("ALL")
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private static final Logger LOGGER  = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private AccountRao accountRao;

    @Override
    public OrderResponse create(String userId, String commodityCode, int orderCount) {

        LOGGER.info("Order Service Begin ... xid: " + RootContext.getXID());

        Order order = new Order();

        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(orderCount);
        Integer orderMoney = calculate(orderCount);
        order.setMoney(orderMoney);

        orderMapper.insert(order);

        LOGGER.info("Order Service End ... Created " + order);

        accountRao.debit(userId,orderMoney);

        OrderResponse orderResponse = new OrderResponse();

        orderResponse.setCode("0");
        orderResponse.setMessage("操作成功");

        return orderResponse;
    }

    private int calculate(int orderCount) {
        return 200 * orderCount;
    }
}
