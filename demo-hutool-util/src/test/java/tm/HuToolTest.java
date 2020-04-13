package tm;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.codec.Base64;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.watch.WatchMonitor;
import cn.hutool.core.io.watch.Watcher;
import cn.hutool.core.lang.Console;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.swing.clipboard.ClipboardUtil;
import cn.hutool.core.text.StrBuilder;
import cn.hutool.core.util.*;
import cn.hutool.http.HtmlUtil;
import cn.hutool.setting.Setting;
import cn.hutool.setting.dialect.Props;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tm.entity.DuibaGroupTopic;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HuToolApplication.class)
public class HuToolTest {

    @Test
    public void test1(){
        System.out.println(Convert.toInt("12345fs"));
    }

    @Test
    public void test2(){
        System.out.println();
        System.out.println(Convert.digitToChinese(new BigDecimal("1234567890")));
        System.out.println();
    }

    @Test
    public void test3(){
        System.out.println();
        System.out.println(Convert.convertTime(12121212132L,
                TimeUnit.MILLISECONDS, TimeUnit.DAYS));
        System.out.println();
    }

    @Test
    public void test4(){
        Date date = new Date();
        DateTime dateTime = new DateTime(date);
        Console.log(dateTime);
    }

    @Test
    public void test5() throws Exception{
        String type = FileTypeUtil.getType(new File(
                "/Users/trouble-man/Documents/演示文稿-DubboSwagger.pptx"));
        System.out.println(type);
    }

    @Test
    public void test6(){
        Boolean clean =  FileUtil.clean(new File("/Users/trouble-man/Documents/演示文稿-DubboSwagger.pptx"));
        System.out.println(clean);
    }

    @Test
    public void test7(){
        File[] files = FileUtil.ls("/Users/trouble-man/script");
        for (File file : files) {
            System.out.println(FileUtil.getName(file));
        }
    }

    @Test
    public void test8(){
        File file = FileUtil.touch("/Users/trouble-man/script/tmmmm/tmmmm.txt");
        System.out.println(file);
    }

    @Test
    public void test9(){
        Props props = Props.getProp("application.properties");
        System.out.println(props);
    }

    @Test
    public void test10(){
        System.out.println(StrUtil.hasBlank("1","1","1","1","1"));
    }

    @Test
    public void test11(){
        String test = "123456789";
        System.out.println();
        System.out.println(StrUtil.sub(test, 0, -6));
        System.out.println();
    }

    @Test
    public void test12(){
        String test = "{}123456789{}";
        System.out.println();
        System.out.println(StrUtil.format(test, "前缀","后缀"));
        System.out.println();
    }

    @Test
    public void test13() throws Exception{
        System.out.println(RuntimeUtil.execForLines("ifconfig"));
    }

    @Test
    public void test14(){
        Console.log(NumberUtil.generateRandomNumber(1, 99, 6));
    }



    @Test
    public void test15(){
        Integer[] arrays = {1, 2, 3, 4, 5};
        System.out.println();
        Console.log(ArrayUtil.contains(arrays, 6));
        System.out.println();
    }

    @Test
    public void test16(){
        Integer [] a = {1, 2, 3};
        String [] b = {"a", "b", "c"};
        Map<Integer, String> map = ArrayUtil.zip(a, b, true);
        System.out.println();
        Console.log(map);
        System.out.println();
    }

    @Test
    public void test17(){
        String test = "123456aaa";
        Console.log(ReUtil.getFirstNumber(test));
    }

    @Test
    public void test18(){
        Console.log(BeanUtil.getPropertyDescriptors(DuibaGroupTopic.class));
        Console.log(BeanUtil.getPropertyDescriptorMap(DuibaGroupTopic.class, true));
    }

    @Test
    public void test19(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println();
        Console.log(CollUtil.join(list,"..."));
        System.out.println();
    }

    @Test
    public void test20(){
        List<Integer> list1 = CollUtil.newArrayList(1,2,3,4,5);
        list1.add(6);
        Console.log(list1);
        List<Integer> list2 = Arrays.asList(1,2,3,4,5);
        list2.add(6);
        Console.log(list2);
    }

    @Test
    public void test21(){
        List<Integer> list = CollUtil.newArrayList();
        list.add(1);
        list.add(2);
        Console.log(CollUtil.sub(list, 0,3));
        Console.log(list.subList(0,3));
    }

    @Test
    public void test22(){
        List<Integer> list = CollUtil.newArrayList(1, null);
        Console.log(CollUtil.isEmpty(list));
        Console.log(CollUtil.hasNull(list));
    }

    @Test
    public void test23(){
        Map<String, Object> map = CollUtil.newHashMap();
        map.put("1","a");
        map.put("2","b");
        map.put("3","3");
        Console.log(MapUtil.getInt(map, "3"));
    }

    @Test
    public void test24() throws Exception{
        Console.log(Base64.encode(new FileInputStream(new File("/Users/trouble-man/Downloads/梦然-少年.mp3"))));
    }

    @Test
    public void test25(){
        TimeInterval timer = DateUtil.timer();
        StringBuilder sb1 = new StringBuilder();
        Console.log(timer.interval());
        for (long i = 0; i < 100000000; i++) {
            sb1.append("1");
        }
        Console.log(timer.interval());
    }

    @Test
    public void test26(){
        TimeInterval timer = DateUtil.timer();
        Console.log(timer.interval());
        StrBuilder sb2 = new StrBuilder();
        for (long i = 0; i < 100000000; i++) {
            sb2.append("1");
            sb2.reset();
        }
        Console.log(timer.interval());
    }

    @Test
    public void test27(){
        Setting setting = new Setting("config/cron.setting");
        Console.log(setting.get("a"));
        Console.log(setting.get("b"));

    }
}
