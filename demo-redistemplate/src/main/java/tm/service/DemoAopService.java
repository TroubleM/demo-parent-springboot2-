package tm.service;

import org.springframework.stereotype.Service;
import tm.constants.RedisCacheKeyContants;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

@Service
public class DemoAopService {

    public Object test(){
        System.out.println("1234");
        return null;
    }

    public Object test2() throws Exception{
        Class<? extends Object> clazz = RedisCacheKeyContants.class;
        Field[] fields = clazz.getDeclaredFields();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            if(field.getType().toString().endsWith("java.lang.String") && Modifier.isStatic(field.getModifiers())){
                set.add(field.get(clazz).toString());
                if (set.size() != i + 1){
                    throw new RuntimeException("field:" + field.getName() + "的值:" + field.get(clazz) + "定义重复，请及时修改");
                }
            }
        }
        return null;
    }

}
