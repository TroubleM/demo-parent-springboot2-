package tm.service;

/**
 * @auther: zhangyi
 * @date: 2019/3/1
 * @Description: 库存业务层
 */
public interface StorageService {

    /**
     * 扣减库存
     *
     * @param commodityCode 商品编号
     * @param count 扣减数量
     */
    void deduct(String commodityCode, int count);

}
