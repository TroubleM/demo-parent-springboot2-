package tm;

import cn.hutool.cron.CronUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @auther: zhangyi
 * @date: 2019/9/16
 * @Description: 启动类
 */
@SpringBootApplication
public class HuToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuToolApplication.class, args);
        // HuTool-Cron开启-且设置为守护线程
        CronUtil.start(true);
/*        //支持秒级别定时任务
        CronUtil.setMatchSecond(true);*/
    }

}
