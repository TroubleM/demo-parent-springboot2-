package tm.redistemplate.export.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import com.baidu.disconf.client.DisconfMgrBean;
import com.baidu.disconf.client.DisconfMgrBeanSecond;
import com.baidu.disconf.client.addons.properties.ReloadablePropertiesFactoryBean;

/**
 * @auther: zhangyi
 * @date: 2019/6/11
 * @Description: disconf配置类
 */
@Configuration
public class DisconfConfig {

    @Bean(destroyMethod = "destroy")
    public DisconfMgrBean disconfMgrBean(){
        DisconfMgrBean disconfMgrBean = new DisconfMgrBean();
        disconfMgrBean.setScanPackage("tm.redistemplate.export.disconf");
        return disconfMgrBean;
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public DisconfMgrBeanSecond disconfMgrBeanSecond(){
        return new DisconfMgrBeanSecond();
    }

    @Bean(name = "reloadablePropertiesFactoryBean")
    @AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
    public ReloadablePropertiesFactoryBean reloadablePropertiesFactoryBean() {
        ReloadablePropertiesFactoryBean propertiesFactoryBean = new ReloadablePropertiesFactoryBean();
        propertiesFactoryBean.setSingleton(true);

        // disconf 配置文件 (这里只有application.properties)
        List<String> fileNames = new ArrayList<>();
        fileNames.add("redis-export-application.properties");

        propertiesFactoryBean.setLocations(fileNames);
        return propertiesFactoryBean;
    }

    @Bean(name = "propertyPlaceholderConfigurer")
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(ReloadablePropertiesFactoryBean reloadablePropertiesFactoryBean){
        PropertyPlaceholderConfigurer placeholderConfigurer = new PropertyPlaceholderConfigurer();
        placeholderConfigurer.setIgnoreResourceNotFound(false);
        placeholderConfigurer.setIgnoreUnresolvablePlaceholders(false);
        try {
            Properties properties = reloadablePropertiesFactoryBean.getObject();
            placeholderConfigurer.setProperties(properties);
        } catch (IOException e) {
            throw new RuntimeException("unable to find properties", e);
        }
        return placeholderConfigurer;
    }

}
