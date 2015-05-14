package com.pgq.simpleweather;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.pgq.simpleweather.Utils.LocationUtils;
import com.pgq.simpleweather.Utils.StringUtils;
import com.pgq.simpleweather.Utils.ToastUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends ActionBarActivity {

    @InjectView(R.id.cityName)
    TextView mCityName;
    @InjectView(R.id.currentWeatherIcon)
    ImageView mCurrentWeatherIcon;
    @InjectView(R.id.temperature)
    TextView mTemperature;
    @InjectView(R.id.temperature_unit)
    TextView mTemperatureUnit;
    @InjectView(R.id.Main_swipe)
    SwipeRefreshLayout mMainSwipe;


    LocationUtils locationUtils = new LocationUtils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        double[] loc = locationUtils.getLocation(getApplicationContext());
        Log.i("aaa",loc+"");
//        String latitude = String.valueOf(loc[0]);
//        String longitude = String.valueOf(loc[1]);
        String latitude = 32+"";
        String longitude = 112+"";
        String url = "http://api.openweathermap.org/data/2.5/weather?lat="+latitude+"&lon="+longitude+"&lang=zh_cn&cnt=10";

        Ion.with(getApplicationContext()).load(url).asJsonObject().setCallback(new FutureCallback<JsonObject>() {
            @Override
            public void onCompleted(Exception e, JsonObject jsonObject) {
                    if (StringUtils.isEmpty(e.getMessage())){
                        ToastUtils.info(getApplicationContext(),"错误");
                    }else{

                    }
            }
        });

    }


}
