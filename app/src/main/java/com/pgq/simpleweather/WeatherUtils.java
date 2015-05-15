package com.pgq.simpleweather;

/**
 * Created by PGQ on 2015-5-15-0015.
 */
public class WeatherUtils {
    public static int[] updateWeatherIcon(int condition, boolean nightTime, int index) {

        int[] ints;

        // Thunderstorm
        if (condition < 300) {
            if (nightTime) {
                return ints = new int[]{index, R.mipmap.tstorm1_night};
            } else {
                return ints = new int[]{index, R.mipmap.tstorm1};
            }
        }
        // Drizzle
        else if (condition < 500) {
            return ints = new int[]{index, R.mipmap.light_rain};

        }
        // Rain / Freezing rain / Shower rain
        else if (condition < 600) {
            return ints = new int[]{index, R.mipmap.shower3};
        }
        // Snow
        else if (condition < 700) {
            return ints = new int[]{index, R.mipmap.snow4};
        }
        // Fog / Mist / Haze / etc.
        else if (condition < 771) {
            if (nightTime) {
                return ints = new int[]{index, R.mipmap.fog_night};
            } else {
                return ints = new int[]{index, R.mipmap.fog};
            }
        }
        // Tornado / Squalls
        else if (condition < 800) {
            return ints = new int[]{index, R.mipmap.tstorm3};
        }
        // Sky is clear
        else if (condition == 800) {
            if (nightTime) {
                return ints = new int[]{index, R.mipmap.sunny_night};
            } else {
                return ints = new int[]{index, R.mipmap.sunny};
            }
        }
        // few / scattered / broken clouds
        else if (condition < 804) {
            if (nightTime) {
                return ints = new int[]{index, R.mipmap.cloudy2_night};
            } else {
                return ints = new int[]{index, R.mipmap.cloudy2};
            }
        }
        // overcast clouds
        else if (condition == 804) {
            return ints = new int[]{index, R.mipmap.overcast};
        }
        // Extreme
        else if ((condition >= 900 && condition < 903) || (condition > 904 && condition < 1000)) {
            return ints = new int[]{index, R.mipmap.tstorm3};
        }
        // Cold
        else if (condition == 903) {
            return ints = new int[]{index, R.mipmap.snow5};
        }
        // Hot
        else if (condition == 904) {
            return ints = new int[]{index, R.mipmap.sunny};
        }
        // Weather condition is not available
        else {
            return ints = new int[]{index, R.mipmap.dunno};
        }
    }
}
