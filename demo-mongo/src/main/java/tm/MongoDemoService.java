package tm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import tm.entity.MongoDemoBean;

@Service
public class MongoDemoService {

    private static final Logger logger = LoggerFactory.getLogger(MongoDemoService.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * @Author zhangyi
     * @Description: 增加数据
     * @Date  2019/12/11
     * @Param [mongoDemoBean]
     * @return java.lang.Object
     **/
    public void test1(MongoDemoBean mongoDemoBean){
        logger.info("mongoTemplate=========:" + mongoTemplate);
        mongoTemplate.save(mongoDemoBean);
    }




}
