/*

package tm.rao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import tm.entity.Order;

*/
/*@FeignClient(name = "demo-eureka-customer")*//*

public interface OrderRao {

    */
/**
     * @Author zhangyi
     * @Description: 创建订单
     * @Date  2019/3/26
     * @Param [orderNo]
     * @return tm.entity.Order
     **//*


    @GetMapping(value = "createOrder")
    Order createOrder(String orderNo);

}
*/
