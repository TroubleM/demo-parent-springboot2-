package tm.controller;

import cn.hutool.cron.Scheduler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.cron.CronUtil;
import cn.hutool.setting.Setting;

import java.util.Iterator;
import java.util.List;

@RestController
public class CronTestController {

    /**
     * @Author zhangyi
     * @Description: 手动修改setting配置文件定时任务
     * @Date  2020/4/13
     * @return java.lang.Object
     **/
    @GetMapping(value = "supplyUpdateSettingCron")
    public Object supplyUpdateSettingCron(){
        Setting setting = new Setting("config/cron.setting");
        setting.put("tm.job", "TestJob.run2", "0/5 * * * * ? ");
        CronUtil.schedule(setting);
        return "supplyUpdateSettingCron";
    }

    /**
     * @Author zhangyi
     * @Description: 重启定时任务
     * @Date  2020/4/11
     * @return java.lang.Object
     **/
    @GetMapping(value = "reStartCron")
    public Object reStartCron(){
        CronUtil.stop();
        CronUtil.restart();
        return "reStart";
    }

    /**
     * @Author zhangyi
     * @Description: 手动添加setting配置的定时任务
     * @Date  2020/4/13
     * @return java.lang.Object
     **/
    @GetMapping(value = "supplyAddCron")
    public Object supplyAddSettingCron(){
        Setting setting = new Setting();
        setting.set("tm.job.TestJob.run2", "*/02 * * * *");
        CronUtil.schedule(setting);
        return "supplyAddSettingCron";
    }

    /**
     * @Author zhangyi
     * @Description: 停止定时器
     * @Date  2020/4/11
     * @return java.lang.Object
     **/
    @GetMapping(value = "stopCron")
    public Object stopCron(){
        CronUtil.stop();
        return "stop";
    }

    @GetMapping(value = "updateCron")
    public Object updateCron(String cron){
        this.updateCronStr(cron);
        CronUtil.stop();
        CronUtil.start(true);
        //支持秒级别定时任务
        CronUtil.setMatchSecond(true);
        return "update";
    }

    private void updateCronStr(String cron){
        Setting setting = new Setting("config/cron.setting");
        setting.set("TestJob.run",cron);
    }

    @GetMapping(value = "manuallyStartCron")
    public Object manuallyStartCron(String cron){
        Setting setting = new Setting();
        setting.set("tm.job.TestJob.run2",cron);
        CronUtil.schedule(setting);
        return "manuallyStartCron";
    }

    @GetMapping(value = "manuallyStartCron2")
    public Object manuallyStartCron2(String cron){
        String id = "1234567uio";
        CronUtil.schedule(id, cron, () ->
                System.out.println("手动执行返回id的定时任务"));
        return "manuallyStartCron2";
    }

    @GetMapping(value = "removeAll")
    public Object removeAll(){
        Scheduler scheduler = CronUtil.getScheduler();
        List<String> ids = scheduler.getTaskTable().getIds();
        System.out.println(ids.getClass());
        Iterator<String> iterator = ids.iterator();
        while (iterator.hasNext()){
            CronUtil.remove(iterator.next());
        }
        return "removeAll";
    }

    @GetMapping(value = "test")
    public Object test(){
        Scheduler scheduler = CronUtil.getScheduler();
        System.out.println(scheduler);
        scheduler.getTaskTable().getIds();
        return "test";
    }

}
