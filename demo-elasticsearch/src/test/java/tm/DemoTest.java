package tm;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
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
    private DemoService demoService;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void testElasticsearchSave(){

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
    public void testElasticsearchFindById(){
        System.out.println(demoRepository.findById(2L));
    }

    @Test
    public void testElasticsearchDelete(){
        DemoBean demoBean = new DemoBean();
        demoBean.setId(2L);

        demoRepository.delete(demoBean);
    }

    @Test
    public void testElasticsearchExistsIndex(){
        IndicesExistsResponse indicesExistsResponse = demoService.existsIndex("demo2");
        System.out.println(indicesExistsResponse.isExists());
    }

    @Test
    public void testElasticsearchCreateIndex(){
        CreateIndexResponse createIndexResponse = demoService.createIndex("demo2");
        System.out.println(createIndexResponse.index());
        System.out.println(createIndexResponse.isAcknowledged());
    }

    @Test
    public void testElasticsearchDeleteIndex(){
        DeleteIndexResponse deleteIndexResponse = demoService.deleteIndex("demo2");
        System.out.println(deleteIndexResponse.isAcknowledged());
    }

    @Test
    public void testElasticsearchFindAll(){
        Iterator<DemoBean> iterator = demoRepository.findAll(
                new Sort("id").descending()).iterator();
        int count = 0;
        while (iterator.hasNext()){
            count += 1;
            DemoBean demoBean = iterator.next();
            System.out.println(demoBean.getCode());
        }
        System.out.println("总数--------" + count);
    }

    @Test
    public void testElasticsearchFindAllByPage(){

        List<Sort.Order> orders = Lists.newArrayList();

        orders.add(new Sort.Order(Sort.Direction.ASC,"id"));
        Sort sort = new Sort(orders);
        DemoPage demoPage = new DemoPage(0,10,1L,sort);

        Page<DemoBean> page = demoRepository.findAll(demoPage);
        System.out.println(page);

        List<DemoBean> demoBeans = page.getContent();

        demoBeans.stream().forEach(demoBean -> System.out.println(demoBean));

    }

    /**
     * @Author zhangyi
     * @Description: 精确匹配及按照id倒序排序-自带分页，1&10
     * @Date  2019/5/28
     * @return void
     **/
    @Test
    public void testElasticsearchSearchQueryBuilderOne(){

        NativeSearchQueryBuilder demoQuery = new NativeSearchQueryBuilder();

        demoQuery.withQuery(QueryBuilders.matchQuery("mail","17760529210@163.com"))
                .withQuery(QueryBuilders.matchQuery("code","75")).
                withSort(SortBuilders.fieldSort("id").order(SortOrder.DESC));

        Iterator<DemoBean> iterator = demoRepository.
                search(demoQuery.build()).iterator();

        System.out.println("精确匹配及按照id倒序排序-------start");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("精确匹配及按照id倒序排序-------end");
    }

    /**
     * @Author zhangyi
     * @Description: 模糊匹配及按照code倒序排序-自带分页，1&10,
     * '?' 表示询问一个未知的占位符，'*' 表示询问0到n个任意占位符，
     * 只有字符串可以模糊匹配
     * @Date  2019/5/28
     * @return void
     **/
    @Test
    public void testElasticsearchSearchQueryBuilderTwo(){

        NativeSearchQueryBuilder demoQuery = new NativeSearchQueryBuilder();

        demoQuery.withQuery(QueryBuilders.wildcardQuery("code","*75*")).
                withSort(SortBuilders.fieldSort("code").order(SortOrder.DESC));
        Iterator<DemoBean> iterator = demoRepository.
                search(demoQuery.build()).iterator();

        System.out.println("模糊匹配及按照code倒序排序-------start");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("模糊匹配及按照code倒序排序-------end");
    }

    /**
     * @Author zhangyi
     * @Description: 布尔查询及按照id正序-自带分页，1&10
     * @Date  2019/5/28
     * @return void
     **/
    @Test
    public void testElasticsearchSearchQueryBuilderThree(){

        NativeSearchQueryBuilder demoQuery = new NativeSearchQueryBuilder();

        demoQuery.withQuery(QueryBuilders.boolQuery().
                must(QueryBuilders.matchQuery("mail","17760529210@163.com"))).
                withSort(SortBuilders.fieldSort("id").order(SortOrder.ASC));

        Iterator<DemoBean> iterator = demoRepository.
                search(demoQuery.build()).iterator();

        System.out.println("布尔查询及按照id正序-------start");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("布尔查询及按照id正序-------end");
    }

    /**
     * @Author zhangyi
     * @Description: 过滤查询及按照id正序
     * @Date  2019/5/28
     * @return void
     **/
    @Test
    public void testElasticsearchSearchQueryBuilderFour(){

        NativeSearchQueryBuilder demoQuery = new NativeSearchQueryBuilder();

        demoQuery.withQuery(QueryBuilders.boolQuery().
                must(QueryBuilders.matchQuery("mail","17760529210@163.com")).
                filter(QueryBuilders.termQuery("id","16"))).
                withSort(SortBuilders.fieldSort("id").order(SortOrder.ASC));

        Iterator<DemoBean> iterator = demoRepository.
                search(demoQuery.build()).iterator();

        System.out.println("过滤查询及按照id正序-------start");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("过滤查询及按照id正序-------end");

    }

    /**
     * @Author zhangyi
     * @Description: 仅仅查询部分字段信息，并高亮
     * BoolQueryBuilder 中匹配的字段才能高亮
     * @Date  2019/5/28
     * @return void
     **/
    @Test
    public void testElasticsearchSearchQueryBuilderFive(){
        BoolQueryBuilder boolQueryBuilder= QueryBuilders.boolQuery().
            must(QueryBuilders.wildcardQuery("code","*75*"));
        NativeSearchQuery nativeSearchQuery=new NativeSearchQueryBuilder()
                .withQuery(boolQueryBuilder)
                .withHighlightFields(new HighlightBuilder.Field("code"))
                .withHighlightBuilder(new HighlightBuilder()
                        .preTags("<span style='color:red'>").postTags("</span>"))
                .withSort(SortBuilders.fieldSort("id").order(SortOrder.DESC)).build();

        AggregatedPage<DemoBean> page = elasticsearchTemplate.queryForPage(
                nativeSearchQuery, DemoBean.class, new SearchResultMapper() {
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse response, Class<T> clazz, Pageable pageable) {

                List<DemoBean> demoBeans = Lists.newArrayList();

                SearchHits searchHits = response.getHits();

                Iterator<SearchHit> iterator = searchHits.iterator();

                while (iterator.hasNext()){
                    SearchHit searchHit = iterator.next();
                    Map<String,Object> searchHitMap = searchHit.getSourceAsMap();

                    DemoBean demoBean = new DemoBean();

                    demoBean.setId(Long.parseLong(searchHitMap.get("id").toString()));

                    demoBean.setUserName(searchHitMap.get("userName").toString());

                    demoBean.setPhone(searchHitMap.get("phone").toString());

                    demoBean.setMail(searchHitMap.get("mail").toString());

                    demoBean.setPassword(searchHitMap.get("password").toString());

                    demoBean.setCode(searchHit.getHighlightFields().get("code").getFragments()[0].toString());

                    demoBeans.add(demoBean);

                }
                return new AggregatedPageImpl<T>((List<T>) demoBeans);
            }
        });

        Iterator<DemoBean> iterator = page.iterator();

        System.out.println("仅仅查询部分字段信息，并高亮id和code-------start");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("仅仅查询部分字段信息，并高亮id和code-------end");
    }

}
