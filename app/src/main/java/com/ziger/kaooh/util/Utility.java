package com.ziger.kaooh.util;

import android.text.TextUtils;

import com.ziger.kaooh.db.KaoohDB;
import com.ziger.kaooh.model.City;
import com.ziger.kaooh.model.County;
import com.ziger.kaooh.model.Province;

/**
 * Created by kaka on 2014/12/9.
 */
public class Utility {
    public synchronized static boolean handleProvinceResponse(KaoohDB kaoohDB, String response) {
        if (TextUtils.isEmpty(response)) {
            String[] allProvinces = response.split(",");
            if (allProvinces != null && allProvinces.length > 0) {
                for (String p : allProvinces) {
                    String[] array = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    kaoohDB.saveProvince(province);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean handleCitiesResponse(KaoohDB kaoohDB,String response, int provinceId){
        if (!TextUtils.isEmpty(response)){
            String[] allCities=response.split(",");
            if (allCities.length>0&&allCities!=null){
                for (String c:allCities){
                    String[] array = c.split("\\|");
                    City city  = new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(provinceId);
                    kaoohDB.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountiesResponse(KaoohDB kaoohDB,
                                                 String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            String[] allCounties = response.split(",");
            if (allCounties != null && allCounties.length > 0) {
                for (String c : allCounties) {
                    String[] array = c.split("\\|");
                    County county = new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(cityId);
                    // 将解析出来的数据存储到County表
                    kaoohDB.saveCounty(county);
                }

                return true;
            }
        }
        return false;
    }

}
