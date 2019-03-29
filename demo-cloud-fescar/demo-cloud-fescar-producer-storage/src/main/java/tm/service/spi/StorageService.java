package tm.service.spi;

public interface StorageService {

    /**
     * @Author zhangyi
     * @Description: 库存同步
     * @Date  2019/3/28
     * @Param [commodityCode, count]
     * @return void
     **/
    void deduct(String commodityCode, int count);

}
