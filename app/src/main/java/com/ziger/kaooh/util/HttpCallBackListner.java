package com.ziger.kaooh.util;

/**
 * Created by kaka on 2014/12/8.
 */
public interface HttpCallBackListner {
    void onFinish(String response);
    void onError(Exception e);
}
