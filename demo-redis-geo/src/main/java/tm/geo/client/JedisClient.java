package tm.geo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.*;
import redis.clients.jedis.params.GeoRadiusParam;

import java.util.List;
import java.util.Map;

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
     * @Description: 添加经纬度数据
     * @Date  2019/4/9
     * @Param [key, geoCoordinate, memberName]
     * @return java.lang.Long
     **/
    public Long geoAdd(String key, GeoCoordinate geoCoordinate, String memberName){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.geoadd(key,geoCoordinate.getLongitude(),geoCoordinate.getLatitude(),memberName);
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
     * @Description: 获取某个点的一定长度内的经纬度集合信息
     * @Date  2019/4/9
     * @Param [key, geoCoordinate, radius]
     * @return java.util.List<redis.clients.jedis.GeoCoordinate>
     **/
    public List<GeoRadiusResponse> geoRadius(String key, GeoCoordinate geoCoordinate, Double radius){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.georadius(key,geoCoordinate.getLongitude(),geoCoordinate.getLatitude(),
                    radius, GeoUnit.KM, GeoRadiusParam.geoRadiusParam().withDist().withCoord().sortAscending());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            release(jedis);
        }
        return null;
    }

    /**
     * @Author zhangyi
     * @Description: 获取某个值的一定长度内的经纬度信息
     * @Date  2019/4/9
     * @Param [key, memberName, redius]
     * @return java.util.List<redis.clients.jedis.GeoRadiusResponse>
     **/
    public List<GeoRadiusResponse> getRadius4MemberName(String key, String memberName, Double radius){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.georadiusByMember(key,memberName,
                    radius, GeoUnit.M, GeoRadiusParam.geoRadiusParam().withDist().withCoord().sortAscending());
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

}
