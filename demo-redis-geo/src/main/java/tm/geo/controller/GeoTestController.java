package tm.geo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;

import redis.clients.jedis.GeoCoordinate;
import tm.geo.client.JedisClient;

@RestController
@RequestMapping(value = "geoTest")
public class GeoTestController {

    private static final String GEO_KEY = "testJedisGeoKey";

    @Autowired
    private JedisClient jedisClient;

    /**
     * @Author zhangyi
     * @Description: 添加经纬度信息
     * @Date  2019/4/11
     * @Param [longitude, latitude, memberName, radius]
     * @return java.lang.Object
     **/
    @GetMapping(value = "geoAdd")
    public Object geoAdd(Double longitude, Double latitude,
                         String memberName,Double radius){
        Map<String,Object> resultMap = Maps.newHashMap();
        resultMap.put("result",jedisClient.geoAdd(GEO_KEY,new GeoCoordinate(
                longitude,latitude),memberName));
        return resultMap;
    }

    /**
     * @Author zhangyi
     * @Description: 清除区域信息
     * @Date  2019/4/10
     * @Param []
     * @return java.lang.Object
     **/
    @GetMapping(value = "geoDel")
    public Object geoDel(){
        try {
            return jedisClient.geoDel(GEO_KEY);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Author zhangyi
     * @Description: 根据经纬度获取周围一定距离的集合信息
     * @Date  2019/4/10
     * @Param [longitude, latitude, radius]
     * @return java.lang.Object
     **/
    @GetMapping(value = "geoRadius")
    public Object geoRadius(Double longitude, Double latitude, Double radius){
        try {
            return jedisClient.geoRadius(GEO_KEY,new GeoCoordinate(longitude,latitude),radius);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Author zhangyi
     * @Description: 根据一个区域的名称获取某一个距离内的地点集合
     * @Date  2019/4/11
     * @Param [memberName, radius]
     * @return java.lang.Object
     **/
    @GetMapping(value = "getRadius4MemberName")
    public Object getRadius4MemberName(String memberName, Double radius){
        try {
            return jedisClient.getRadius4MemberName(GEO_KEY, memberName, radius);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
