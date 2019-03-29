package tm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhangyi
 * @date 2018/9/21 14:11
 * @Description: swagger相关配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * @auther: zhangyi
     * @date: 2018/9/21 14:15
     * @param:
     * @return: Docket
     * @Description: 基础配置
     */
    @Bean
    public Docket createRestApi() {
        /**
         * 获取swagger开关配置
         */
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("tm.controller"))
                .paths(PathSelectors.any())
                .build();

    }

    /**
     * @auther: zhangyi
     * @date: 2018/9/21 14:15
     * @param:
     * @return: ApiInfo
     * @Description:信息说明
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("fescar消费者控制层")
                .description("fescar微服务cloud")
                .termsOfServiceUrl("http://www.duia.com")
                .contact("tm")
                .version("1.0")
                .build();
    }

}
