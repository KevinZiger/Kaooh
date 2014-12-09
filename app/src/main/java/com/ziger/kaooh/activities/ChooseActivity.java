package com.ziger.kaooh.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ziger.kaooh.R;
import com.ziger.kaooh.model.City;
import com.ziger.kaooh.model.County;
import com.ziger.kaooh.model.Province;

import java.util.ArrayList;
import java.util.List;

public class ChooseActivity extends Activity {

    private TextView titleView;
    private ListView listView;

    private List<Province> provinceList;
    private List<City> cityList;
    private List<County> countyList;

    private List<String> dataList ;
    private Province selectedProvince;
    private City selectedCity;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_area);

        initView();
        initData();
    }

    private void initData() {
        provinceList = new ArrayList<>();
        cityList = new ArrayList<>();


    }

    private void initView() {
        titleView = (TextView) findViewById(R.id.title_text);
        listView = (ListView) findViewById(R.id.list_view);

    }
}
