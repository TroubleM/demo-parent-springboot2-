package tm.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tm.eureka.rao.StorageRao;

@RequestMapping(value = "storage-hystrix")
public class StorageRaoHystrix implements StorageRao {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageRaoHystrix.class);

    @Override
    public Object deduct(@RequestParam(value = "commodityCode") String commodityCode,
                         @RequestParam(value = "count") int count,
                         @RequestParam(value = "code") String code) {

        LOGGER.error("-----------库存熔断器执行-----------");
        return null;
    }
}
