package tm.geo.response;

import redis.clients.jedis.GeoCoordinate;

/**
 * @auther: zhangyi
 * @date: 2019/5/17
 * @Description: 经纬度坐标点返回对象
 */
public class MyGeoRadiusResponse {

    /**
     * @auther: zhangyi
     * @date: 2019/5/17
     * @Description: 坐标点名称
     */
    private String member;
    /**
     * @auther: zhangyi
     * @date: 2019/5/17
     * @Description: 距离
     */
    private double distance;

    /**
     * @auther: zhangyi
     * @date: 2019/5/17
     * @Description: 坐标点信息
     */
    private GeoCoordinate coordinate;

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public GeoCoordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(GeoCoordinate coordinate) {
        this.coordinate = coordinate;
    }
}
