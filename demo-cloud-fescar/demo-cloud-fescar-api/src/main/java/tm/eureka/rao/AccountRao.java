package tm.eureka.rao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tm.hystrix.AccountRaoHystrix;

@FeignClient(name = "demo-cloud-fescar-account-server",fallback = AccountRaoHystrix.class)
@RequestMapping(value = "account")
public interface AccountRao {

    @RequestMapping(value = "debit")
    Object debit(@RequestParam(value = "userId") String userId,
                 @RequestParam(value = "money") int money);

}
