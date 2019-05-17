package tm.geo.controller;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import redis.clients.jedis.GeoCoordinate;
import redis.clients.jedis.GeoUnit;
import tm.geo.client.JedisClient;

/**
 * @auther: zhangyi
 * @date: 2019/5/17
 * @Description: Geo测试控制层
 */
@RestController
@RequestMapping(value = "geoTest")
@Api("Geo测试控制层")
public class GeoTestController {

    /**
     * @auther: zhangyi
     * @date: 2019/5/17
     * @Description: 公用的测试Geo集合的key
     */
    private static final String GEO_KEY = "testJedisGeoKey";

    @Autowired
    private JedisClient jedisClient;

    /**
     * @Author zhangyi
     * @Description: 添加坐标
     * @Date  2019/4/11
     * @Param [longitude, latitude, memberName]
     * @return java.lang.Object
     **/
    @PostMapping(value = "geoAdd")
    @ApiOperation("添加坐标")
    public Object geoAdd(@ApiParam("经度") @RequestParam(value = "longitude") Double longitude,
                         @ApiParam("纬度") @RequestParam(value = "latitude") Double latitude,
                         @ApiParam("坐标点名称") @RequestParam(value = "memberName") String memberName){
        try {
            Map<String,Object> resultMap = Maps.newHashMap();
            resultMap.put("result",jedisClient.geoAdd(GEO_KEY,new GeoCoordinate(
                    longitude,latitude),memberName));
            return resultMap;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Author zhangyi
     * @Description: 批量添加坐标、
     * @Date  2019/5/17
     * @Param [paramStr]
     * @return java.lang.Object
     **/
    @PostMapping(value = "geoAddBatch")
    @ApiOperation("批量添加坐标")
    public Object geoAddBatch(@ApiParam("坐标集合,key为坐标名称,value为坐标点对象")
                                  @RequestParam(value = "paramStr") String paramStr){
        try {
            //数据封装
            Map<String,JSONObject> jsonObjectMap = JSONObject.parseObject(paramStr, Map.class);

            //入参
            Map<String,GeoCoordinate> paramMap = Maps.newHashMap();

            Set<String> keySets = jsonObjectMap.keySet();
            for (String key : keySets){
                paramMap.put(key,JSONObject.parseObject(
                        jsonObjectMap.get(key).toJSONString(),GeoCoordinate.class));
            }
            //执行保存
            Map<String,Object> resultMap = Maps.newHashMap();
            resultMap.put("result",jedisClient.geoAddBatch(GEO_KEY,paramMap));
            return resultMap;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Author zhangyi
     * @Description: 根据坐标名称获取坐标信息
     * @Date  2019/5/17
     * @Param [memberName]
     * @return java.lang.Object
     **/
    @PostMapping(value = "geoPos")
    @ApiOperation("根据坐标名称获取坐标信息")
    public Object geoPos(@ApiParam("坐标点名称")
                         @RequestParam(value = "memberName") String memberName){
        try {
            Map<String,Object> resultMap = Maps.newHashMap();
            resultMap.put("result",jedisClient.geoPos(GEO_KEY,memberName));
            return resultMap;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    /**
     * @Author zhangyi
     * @Description: 根据经纬度获取周围一定距离的集合信息，这里默认距离为千米
     * @Date  2019/4/10
     * @Param [longitude, latitude, radius]
     * @return java.lang.Object
     **/
    @PostMapping(value = "geoRadius")
    @ApiOperation("根据经纬度获取周围一定距离的集合信息")
    public Object geoRadius(@ApiParam("经度") @RequestParam(value = "longitude") Double longitude,
                            @ApiParam("纬度") @RequestParam(value = "latitude") Double latitude,
                            @ApiParam("距离半径") @RequestParam(value = "radius") Double radius){
        try {
            Map<String,Object> resultMap = Maps.newHashMap();
            resultMap.put("result",jedisClient.geoRadius(GEO_KEY,
                    new GeoCoordinate(longitude,latitude),radius));
            return resultMap;
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
    @PostMapping(value = "getRadius4MemberName")
    @ApiOperation("根据坐标点的名称获取某一个距离内的地点集合")
    public Object getRadius4MemberName(@ApiParam("坐标点名称") @RequestParam(value = "memberName")
                                                   String memberName,
                                       @ApiParam("距离半径") @RequestParam(value = "radius")
                                               Double radius){
        try {
            Map<String,Object> resultMap = Maps.newHashMap();
            resultMap.put("result",jedisClient.getRadius4MemberName(GEO_KEY, memberName
                    ,radius));
            return resultMap;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Author zhangyi
     * @Description: 根据坐标点名称获取两点之间距离,这里默认单位为千米
     * @Date  2019/5/17
     * @Param [fristMemberName, lastMemberName, geoUnit]
     * @return java.lang.Object
     **/
    @PostMapping(value = "geoDist")
    @ApiOperation("根据坐标点名称获取两点之间距离")
    public Object geoDist(@ApiParam("第一个坐标名称") @RequestParam(value = "fristMemberName")
                                      String fristMemberName,
                          @ApiParam("第二个坐标名称") @RequestParam(value = "lastMemberName")
                                  String lastMemberName){
        try {
            Map<String,Object> resultMap = Maps.newHashMap();
            resultMap.put("result",jedisClient.geoDist(GEO_KEY,fristMemberName,lastMemberName
                    ,GeoUnit.KM));
            return resultMap;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    /**
     * @Author zhangyi
     * @Description: 根据坐标点的名称数据删除坐标点
     * @Date  2019/5/17
     * @Param [memberNames]
     * @return java.lang.Object
     **/
    @PostMapping(value = "geoDelCoordinates")
    @ApiOperation("根据坐标点的名称数据删除坐标点")
    public Object geoDelCoordinates(@ApiParam("坐标点名称集合") @RequestParam(value = "memberNames")
                                                String[] memberNames){
        try {
            Map<String,Object> resultMap = Maps.newHashMap();
            resultMap.put("result",jedisClient.geoDelCoordinates(GEO_KEY,memberNames));
            return resultMap;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Author zhangyi
     * @Description: 清除区域信息
     * @Date  2019/4/10
     * @Param []
     * @return java.lang.Object
     **/
    @PostMapping(value = "geoDel")
    @ApiOperation("清除区域信息")
    public Object geoDel(){
        try {
            return jedisClient.geoDel(GEO_KEY);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
