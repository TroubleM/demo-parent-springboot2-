package tm.elasticsearch.dao;


/**
 * @auther: zhangyi
 * @date: 2019/5/24
 * @Description: es数据操作层
 */

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import tm.elasticsearch.bean.DemoBean;

@Component
public interface DemoRepository extends ElasticsearchRepository<DemoBean,Long> {

}

