package tm.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

/**
 * @auther: zhangyi
 * @date: 2019/9/19
 * @Description: 利用spring的bean拷贝方法二次封装
 */
public class BeanCopyUtils {

    private static final Logger logger = LoggerFactory.getLogger(BeanCopyUtils.class);

    /**
     * @Author zhangyi
     * @Description: 对象拷贝
     * @Date  2019/9/19
     * @Param [source, clazz]
     * @return java.lang.Object
     **/
    public static<T> T copyBean(Object source, Class<? extends T> clazz){
        if(null == source){
            return null;
        }
        try {
            T target = clazz.newInstance();
            BeanUtils.copyProperties(source,target);
            return target;
        } catch (Exception e) {
            logger.error("JavaBean拷贝异常:----" +"[" + source.getClass().getName()
                    + "] To [" + clazz.getName() + "] :", e);
            return null;
        }
    }

}
