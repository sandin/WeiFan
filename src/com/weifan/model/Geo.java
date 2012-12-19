package com.weifan.model;

import com.j256.ormlite.field.DatabaseField;

public class Geo {
    
    @DatabaseField(id = true)
    private long id;

    @DatabaseField
    private String longitude; // string 经度坐标
    @DatabaseField
    private String latitude; // string 维度坐标
    @DatabaseField
    private String city; // string 所在城市的城市代码
    @DatabaseField
    private String province; // string 所在省份的省份代码
    @DatabaseField
    private String city_name; // string 所在城市的城市名称
    @DatabaseField
    private String province_name; // string 所在省份的省份名称
    @DatabaseField
    private String address; // string 所在的实际地址，可以为空
    @DatabaseField
    private String pinyin; // string 地址的汉语拼音，不是所有情况都会返回该字段
    @DatabaseField
    private String more; // string 更多信息，不是所有情况都会返回该字段

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }

    @Override
    public String toString() {
        return "Geo [longitude=" + longitude + ", latitude=" + latitude
                + ", city=" + city + ", province=" + province + ", city_name="
                + city_name + ", province_name=" + province_name + ", address="
                + address + ", pinyin=" + pinyin + ", more=" + more + "]";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
