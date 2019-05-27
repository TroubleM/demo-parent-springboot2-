package tm;

import java.util.List;

import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.Lists;

import tm.elasticsearch.bean.DemoBean;
import tm.elasticsearch.dao.DemoRepository;
import tm.elasticsearch.page.DemoPage;
import tm.elasticsearch.service.DemoService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElasticsearchApplication.class)
public class DemoTest {

    @Autowired
    private DemoRepository demoRepository;

    @Autowired
    private TransportClient transportClient;

    @Autowired
    private DemoService demoService;

    @Test
    public void test1(){

        for (long i = 1l; i <= 1000; i++){
            DemoBean demoBean = new DemoBean();

            demoBean.setId(i);
            demoBean.setCode("123456" + "-" + i);
            demoBean.setPassword("654321" + "-" + i);
            demoBean.setMail("17760529210@163.com" + "-" + i);
            demoBean.setPhone("17760529210" + "-" + i);
            demoBean.setUserName("你看我有戏" + "-" + i);
            demoRepository.save(demoBean);
        }
    }

    @Test
    public void test2(){
        System.out.println(transportClient);
        System.out.println(demoRepository.findById(2L));
    }

    @Test
    public void test3(){
        DemoBean demoBean = new DemoBean();
        demoBean.setId(2L);

        demoRepository.delete(demoBean);
    }

    @Test
    public void test4(){
        IndicesExistsResponse indicesExistsResponse = demoService.existsIndex("demo2");
        System.out.println(indicesExistsResponse.isExists());
    }

    @Test
    public void test5(){
        CreateIndexResponse createIndexResponse = demoService.createIndex("demo2");
        System.out.println(createIndexResponse.index());
        System.out.println(createIndexResponse.isAcknowledged());
    }

    @Test
    public void test6(){
        DeleteIndexResponse deleteIndexResponse = demoService.deleteIndex("demo2");
        System.out.println(deleteIndexResponse.isAcknowledged());
    }

    @Test
    public void test7(){
        List<Sort.Order> orders = Lists.newArrayList();
        orders.add(new Sort.Order("id"));
        Sort sort = new Sort(orders);
        DemoPage demoPage = new DemoPage(0,10,1L,sort);

        Page<DemoBean> page = demoRepository.findAll(demoPage);
        System.out.println(page);

        List<DemoBean> demoBeans = page.getContent();

        demoBeans.stream().forEach(demoBean -> System.out.println(demoBean));

    }

}
