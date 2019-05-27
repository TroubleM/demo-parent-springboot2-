package tm.elasticsearch.service;

import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther: zhangyi
 * @date: 2019/5/27
 * @Description: Es demo业务层
 */
@Service
public class DemoService {

    @Autowired
    private TransportClient transportClient;

    // 创建索引
    public CreateIndexResponse createIndex(String index){
        return this.transportClient.admin()
                .indices().prepareCreate(index).get();
    }

    // 删除索引
    public DeleteIndexResponse deleteIndex(String index){
        return this.transportClient.admin()
                .indices().prepareDelete(index).get();
    }

    public IndicesExistsResponse existsIndex(String index){
        return this.transportClient.admin()
                .indices().prepareExists(index).get();
    }

}
