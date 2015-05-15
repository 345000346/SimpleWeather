package com.pgq.simpleweather.Utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by PGQ on 2015-5-14-0014.
 */
public class TimeUtils {

    public static String TimeStamp2Date(String timestampString, String formats) {
        Long timestamp = Long.parseLong(timestampString) * 1000;
        return new SimpleDateFormat(formats, Locale.getDefault()).format(new java.util.Date(timestamp));
    }

    public static String Unix2Time(String unixTime){
        return TimeStamp2Date(unixTime,"yyyy-MM-dd HH:mm:ss");
    }
}
