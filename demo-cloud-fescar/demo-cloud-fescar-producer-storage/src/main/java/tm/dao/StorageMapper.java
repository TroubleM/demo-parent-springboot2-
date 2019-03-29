package tm.dao;

import tm.bean.Storage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StorageMapper {
    /**
     *
     * @mbg.generated 2019-03-14
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2019-03-14
     */
    int insert(Storage record);

    /**
     *
     * @mbg.generated 2019-03-14
     */
    int insertSelective(Storage record);

    /**
     *
     * @mbg.generated 2019-03-14
     */
    Storage selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2019-03-14
     */
    int updateByPrimaryKeySelective(Storage record);

    /**
     *
     * @mbg.generated 2019-03-14
     */
    int updateByPrimaryKey(Storage record);

    /**
     * @auther: zhangyi
     * @date: 2019/3/14
     * @Description: 订单增加后修改账户
     */
    int updateForOrder(Storage storage) /*throws IOException*/;
}