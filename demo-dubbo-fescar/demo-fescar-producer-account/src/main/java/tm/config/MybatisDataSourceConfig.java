package tm.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fescar.rm.datasource.DataSourceProxy;

/**
 * @auther: zhangyi
 * @date: 2019/3/14
 * @Description: Mybatis配置
 */
@Configuration
@MapperScan(basePackages = "tm.dao")
public class MybatisDataSourceConfig {

    @Bean(name = "accountDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.account")
    public DruidDataSource druidDataSource(){
        //通过DataSourceBuilder构建数据源
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    /**
     * @Author zhangyi
     * @Description: SqlSession工厂
     * @Date  2019/3/14
     * @Param
     * @return
     **/
    @Bean(name = "accountSqlSessionFactory")
    @Primary
    @Qualifier("accountDataSourceProxy")
    public SqlSessionFactory orderSqlSessionFactory(DataSourceProxy accountDataSourceProxy)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(accountDataSourceProxy);
        //由于拆分了包结构，这里指定mapper
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().
                getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }

    /**
     * @Author zhangyi
     * @Description: 事务管理器
     * @Date  2019/3/14
     * @Param
     * @return
     **/
    @Bean(name = "accountTransactionManager")
    @Primary
    public DataSourceTransactionManager orderTransactionManager(DataSourceProxy accountDataSourceProxy) {
        return new DataSourceTransactionManager(accountDataSourceProxy);
    }

    /**
     * @Author zhangyi
     * @Description: SqlSession配置
     * @Date  2019/3/14
     * @Param
     * @return
     **/
    @Bean(name = "accountSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate orderSqlSessionTemplate(
            @Qualifier("accountSqlSessionFactory") SqlSessionFactory accountSqlSessionFactory) {
        return new SqlSessionTemplate(accountSqlSessionFactory);
    }

}
