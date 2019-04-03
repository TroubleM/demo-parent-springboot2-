package tm.eureka.rao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tm.hystrix.StorageRaoHystrix;

@FeignClient(name = "demo-cloud-fescar-storage-producer",fallback = StorageRaoHystrix.class)
@RequestMapping(value = "storage")
public interface StorageRao {

    @RequestMapping(value = "deduct")
    Object deduct(@RequestParam(value = "commodityCode") String commodityCode,
                  @RequestParam(value = "count") int count,
                  @RequestParam(value = "code") String code);

}
