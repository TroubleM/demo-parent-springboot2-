package tm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tm.entity.MongoDemoBean;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MongoApplication.class)
public class MongoDemoTest {

    @Autowired
    private MongoDemoService mongoDemoService;

    @Test
    public void test1(){
        MongoDemoBean mongoDemoBean = new MongoDemoBean();
        mongoDemoBean.setAge(26);
        mongoDemoBean.setBirthdate(new Date());
        mongoDemoBean.setId(1L);
        mongoDemoBean.setName("我看你有戏");
        mongoDemoService.test1(mongoDemoBean);
    }

}
