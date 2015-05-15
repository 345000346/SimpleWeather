package com.pgq.simpleweather;

import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.pgq.simpleweather.Bean.CurrentWeatherBean;
import com.pgq.simpleweather.Utils.APIUtils;
import com.pgq.simpleweather.Utils.LocationUtils;
import com.pgq.simpleweather.Utils.TimeUtils;
import com.pgq.simpleweather.Utils.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.cityName)
    TextView mCityName;
    @InjectView(R.id.currentWeatherIcon)
    ImageView mCurrentWeatherIcon;
    @InjectView(R.id.temperature)
    TextView mTemperature;
    @InjectView(R.id.temperature_unit)
    TextView mTemperatureUnit;
    @InjectView(R.id.currentWeatherTime)
    TextView mCurrentWeatherTime;
    @InjectView(R.id.loading)
    LinearLayout mLoading;
    @InjectView(R.id.loading_text)
    TextView mLoadingText;
    @InjectView(R.id.loading_progress)
    ContentLoadingProgressBar mLoadingProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        disptcher();
    }

    private void disptcher() {
        String url = getUrl();
        getCurrentWeather(url);
    }

    private void getCurrentWeather(String url) {
        Ion.with(getApplicationContext()).load(url).asString().setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String s) {
                if (e != null) {
                    loadFailed();
                } else {
                    try {
                        JSONObject jsonObject = new JSONObject(s);
                        String cod = jsonObject.getString("cod");
                        if (cod.equals("200")) {
                            getCurrentSuccess(s);
                            dismissLoading();//
                        } else if (cod.equals("404")) {
                            ToastUtils.info(getApplicationContext(), jsonObject.getString("Message"));
                            loadFailed();
                        }
                    } catch (JSONException e1) {
                        e1.printStackTrace();
                        loadFailed();
                    }
                }
            }
        });
    }

    private void getCurrentSuccess(String s) {
        CurrentWeatherBean currentWeatherBean = new Gson().fromJson(s, CurrentWeatherBean.class);
        String cityName = currentWeatherBean.getName();
        String icon = currentWeatherBean.getWeather().get(0).getIcon();
        String temperature = new DecimalFormat("###.0").format(currentWeatherBean.getMain().getTemp());
        String currentWeatherTime = TimeUtils.Unix2Time(currentWeatherBean.getDt() + "");
        int condition = currentWeatherBean.getWeather().get(0).getId();

        int[] iconinfo = WeatherUtils.updateWeatherIcon(condition, isNight(icon), 0);
        updatePictures(iconinfo[0], iconinfo[1]);

        mCityName.setText(cityName);
        mTemperature.setText(temperature);
        mCurrentWeatherTime.setText(currentWeatherTime);
    }

    private void updatePictures(int index, int name) {
        switch (index) {
            case 0:
                mCurrentWeatherIcon.setImageResource(name);
                break;
            case 1:
                mCurrentWeatherIcon.setImageResource(name);
                break;
            case 2:
                mCurrentWeatherIcon.setImageResource(name);
                break;
            case 3:
                mCurrentWeatherIcon.setImageResource(name);
                break;
            case 4:
                mCurrentWeatherIcon.setImageResource(name);
                break;
        }
    }


    private boolean isNight(String icon) {
        return icon.contains("n");
    }

    private String getUrl() {
        LocationUtils locationUtils = new LocationUtils();
        double[] loc = locationUtils.getLocation(getApplicationContext());
        String latitude = String.valueOf(loc[0]);
        String longitude = String.valueOf(loc[1]);
        return APIUtils.CURRENTURL + "lat=" + latitude + "&lon=" + longitude + "&lang=zh_cn&cnt=10&units=metric";
    }

    public void dismissLoading() {
        mLoading.setVisibility(View.GONE);
        mLoadingProgress.setVisibility(View.GONE);
    }

    public void loadFailed() {
        mLoadingText.setText("Load Failed");
        mLoadingProgress.setVisibility(View.GONE);
    }
}
