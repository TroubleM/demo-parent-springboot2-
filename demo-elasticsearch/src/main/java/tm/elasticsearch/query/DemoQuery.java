package tm.elasticsearch.query;

import java.io.IOException;

import org.apache.lucene.search.Query;
import org.elasticsearch.common.io.stream.StreamOutput;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryShardContext;

/**
 * @auther: zhangyi
 * @date: 2019/5/27
 * @Description: Es demo查询入参对象
 */
public class DemoQuery implements QueryBuilder {
    @Override
    public Query toQuery(QueryShardContext queryShardContext) throws IOException {
        return null;
    }

    @Override
    public Query toFilter(QueryShardContext queryShardContext) throws IOException {
        return null;
    }

    @Override
    public QueryBuilder queryName(String s) {
        return null;
    }

    @Override
    public String queryName() {
        return null;
    }

    @Override
    public float boost() {
        return 0;
    }

    @Override
    public QueryBuilder boost(float v) {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getWriteableName() {
        return null;
    }

    @Override
    public void writeTo(StreamOutput streamOutput) throws IOException {

    }

    @Override
    public XContentBuilder toXContent(XContentBuilder xContentBuilder, Params params) throws IOException {
        return null;
    }
}
