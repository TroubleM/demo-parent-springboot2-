package tm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MapperSelectOrFindAspect {

    /**
     * @auther: zhangyi
     * @date: 2019/9/18
     * @Description: 数据库查询切面监控表达式
     */
    private static final String SELECT_OR_FIND_EXECUTION = "execution(public * org.springframework.data.redis.core.RedisTemplate.*(..))";

    /**
     * @Author zhangyi
     * @Description: 监控数据库select开头的方法
     * @Date  2019/9/18
     **/
    @Pointcut(SELECT_OR_FIND_EXECUTION)
    public void selectOrFindTiming() {}

    /**
     * @Author zhangyi
     * @Description: select前缀方法执行之前
     * @Date  2019/9/18
     * @Param [joinPoint]
     **/
    @Before("tm.aspect.MapperSelectOrFindAspect.selectOrFindTiming()")
    public void selectBefore(JoinPoint joinPoint) {
        System.out.println("redis入参增加前缀" + "demoPrefix");
        Object[] objects = joinPoint.getArgs();
        Object[] handelObjects = new Object[objects.length];

        for (int i = 0; i < objects.length; i++) {
            handelObjects[i] = objects[i].toString() + "demoPrefix";
        }
        objects = handelObjects;
    }

    /**
     * @Author zhangyi
     * @Description: select前缀方法执行之后
     * @Date  2019/9/18
     **/
    @After("tm.aspect.MapperSelectOrFindAspect.selectOrFindTiming()")
    public void selectAfter(JoinPoint joinPoint) {
        System.out.println(joinPoint);
        System.out.println("2");
    }

}

