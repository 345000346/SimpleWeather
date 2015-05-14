package com.pgq.simpleweather.Utils;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;

/**
 * Created by PGQ on 2015-5-14-0014.
 */
public class LocationUtils {
    public double[] getLocation(Context context) {
        double[] loc;
        double latitude;
        double longitude;
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        String bestProvider = locationManager.getBestProvider(new Criteria(),
                true);
        Location location = locationManager.getLastKnownLocation(bestProvider);
        if (location != null) {
            latitude = location.getLatitude();
            longitude = location.getLongitude();
            System.out.println(latitude + "," + longitude);
            return loc = new double[]{latitude, longitude};
        } else {
            System.out.println("无法获取地理信息");
        }
        return null;
    }
}
