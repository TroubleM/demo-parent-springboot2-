package tm.geo.client;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import redis.clients.jedis.*;
import redis.clients.jedis.params.GeoRadiusParam;
import tm.geo.response.MyGeoRadiusResponse;

/**
 * @auther: zhangyi
 * @date: 2019/4/9
 * @Description: jedis客户端
 */
@Component
public class JedisClient {

    @Autowired
    private JedisPool jedisPool;

    /**
     * @Author zhangyi
     * @Description: 添加经纬度坐标点数据
     * @Date  2019/4/9
     * @Param [key, geoCoordinate, memberName]
     * @return java.lang.Long 返回成功存入数据数量
     **/
    public Long geoAdd(String key, GeoCoordinate geoCoordinate, String memberName){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.geoadd(key,geoCoordinate.getLongitude(),
                    geoCoordinate.getLatitude(),memberName);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            release(jedis);
        }
        return null;
    }

    /**
     * @Author zhangyi
     * @Description: 批量添加经纬度数据
     * @Date  2019/4/9
     * @Param [key, paramMap]
     * @return java.lang.Long
     **/
    public Long geoAddBatch(String key, Map<String, GeoCoordinate> paramMap){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
                    return jedis.geoadd(key,paramMap);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            release(jedis);
        }
        return null;
    }

    /**
     * @Author zhangyi
     * @Description: 根据坐标点名称获取坐标点信息
     * @Date  2019/5/17
     * @Param [key, memberName]
     * @return java.util.List<redis.clients.jedis.GeoCoordinate>
     **/
    public List<GeoCoordinate> geoPos(String key, String memberName){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.geopos(key,memberName);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            release(jedis);
        }
        return null;
    }

    /**
     * @Author zhangyi
     * @Description: 获取某个点的一定长度内的坐标点集合信息
     * @Date  2019/4/9
     * @Param [key, geoCoordinate, radius]
     * @return java.util.List<redis.clients.jedis.GeoCoordinate>
     **/
    public List<MyGeoRadiusResponse> geoRadius(String key, GeoCoordinate geoCoordinate, Double radius){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            List<GeoRadiusResponse> geoRadiusResponses = jedis.georadius(key,geoCoordinate.getLongitude()
                    ,geoCoordinate.getLatitude(), radius, GeoUnit.KM, GeoRadiusParam.geoRadiusParam()
                            .withDist().withCoord().sortAscending());
            return this.handleMyGeoRadiusResponse(geoRadiusResponses);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            release(jedis);
        }
        return null;
    }

    /**
     * @Author zhangyi
         * @Description: 获取某个坐标名称一定长度内的坐标点信息
     * @Date  2019/4/9
     * @Param [key, memberName, redius]
     * @return java.util.List<redis.clients.jedis.GeoRadiusResponse>
     **/
    public List<MyGeoRadiusResponse> getRadius4MemberName(String key, String memberName, Double radius){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            List<GeoRadiusResponse> geoRadiusResponses = jedis.georadiusByMember(key,memberName,
                    radius, GeoUnit.KM, GeoRadiusParam.geoRadiusParam().
                            withDist().withCoord().sortAscending());
            return this.handleMyGeoRadiusResponse(geoRadiusResponses);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            release(jedis);
        }
        return null;
    }

    /**
     * @Author zhangyi
     * @Description: 计算两者间的距离
     * @Date  2019/4/9
     * @Param [key, fristMemberName, lastMemberName, geoUnit]
     * @return java.lang.Double
     **/
    public Double geoDist(String key, String fristMemberName, String lastMemberName, GeoUnit geoUnit){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.geodist(key,fristMemberName,lastMemberName,geoUnit);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            release(jedis);
        }
        return null;
    }

    /**
     * @Author zhangyi
     * @Description: 根据坐标名称数据删除对应坐标点
     * @Date  2019/5/17
     * @Param [key, members]
     * @return java.lang.Long
     **/
    public Long geoDelCoordinates(String key, String... members){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.zrem(key,members);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            release(jedis);
        }
        return null;
    }

    /**
     * @Author zhangyi
     * @Description: 根据key删除经纬度集合
     * @Date  2019/4/10
     * @Param [key]
     * @return java.lang.Long
     **/
    public Long geoDel(String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.del(key);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            release(jedis);
        }
        return null;
    }

    /**
     * @Author zhangyi
     * @Description: 释放连接
     * @Date  2019/4/9
     * @Param [jedis]
     * @return void
     **/
    private void release(Jedis jedis){
        if(null != jedis){
            jedis.close();
        }
    }

    /**
     * @Author zhangyi
     * @Description: 坐标点返回值封装
     * @Date  2019/5/17
     * @Param [geoRadiusResponses]
     * @return java.util.List<tm.geo.response.MyGeoRadiusResponse>
     **/
    private List<MyGeoRadiusResponse> handleMyGeoRadiusResponse(
            List<GeoRadiusResponse> geoRadiusResponses){
        //返回集合
        List<MyGeoRadiusResponse> resultList = Lists.newArrayList();

        for (GeoRadiusResponse geoRadiusResponse : geoRadiusResponses){
            MyGeoRadiusResponse myGeoRadiusResponse = new MyGeoRadiusResponse();
            BeanUtils.copyProperties(geoRadiusResponse,myGeoRadiusResponse);
            myGeoRadiusResponse.setMember(new String(geoRadiusResponse.getMember()));
            resultList.add(myGeoRadiusResponse);
        }
        return resultList;
    }

}
