package com.ziger.kaooh.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by kaka on 2014/12/8.
 */
public class HttpUtil {
    public static void SendHttpRequest(final String address,
                                       final HttpCallBackListner listner){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try{
                    URL url = new URL(address);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null){
                        response.append(line);
                    }

                    if (listner != null){
                        listner.onFinish(response.toString());
                    }
                } catch (Exception e) {
                    listner.onError(e);
                }finally {
                    if (connection != null){
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

}
