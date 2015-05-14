package com.pgq.simpleweather.Bean;

import java.util.List;

/**
 * Created by PGQ on 2015-5-14-0014.
 */
public class CurrentWeatherBean {

    /**
     * dt : 1431588384
     * coord : {"lon":116.41,"lat":39.9}
     * weather : [{"icon":"01d","description":"晴","main":"Clear","id":800}]
     * name : Beijing
     * cod : 200
     * main : {"temp":299.543,"temp_min":299.543,"grnd_level":996.39,"humidity":25,"pressure":996.39,"sea_level":1022.5,"temp_max":299.543}
     * clouds : {"all":0}
     * id : 1816670
     * sys : {"country":"China","sunrise":1431550812,"sunset":1431602472,"message":0.0983}
     * base : stations
     * wind : {"deg":195.501,"speed":1.3}
     */
    private int dt;
    private CoordEntity coord;
    private List<WeatherEntity> weather;
    private String name;
    private int cod;
    private MainEntity main;
    private CloudsEntity clouds;
    private int id;
    private SysEntity sys;
    private String base;
    private WindEntity wind;

    public void setDt(int dt) {
        this.dt = dt;
    }

    public void setCoord(CoordEntity coord) {
        this.coord = coord;
    }

    public void setWeather(List<WeatherEntity> weather) {
        this.weather = weather;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setMain(MainEntity main) {
        this.main = main;
    }

    public void setClouds(CloudsEntity clouds) {
        this.clouds = clouds;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSys(SysEntity sys) {
        this.sys = sys;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setWind(WindEntity wind) {
        this.wind = wind;
    }

    public int getDt() {
        return dt;
    }

    public CoordEntity getCoord() {
        return coord;
    }

    public List<WeatherEntity> getWeather() {
        return weather;
    }

    public String getName() {
        return name;
    }

    public int getCod() {
        return cod;
    }

    public MainEntity getMain() {
        return main;
    }

    public CloudsEntity getClouds() {
        return clouds;
    }

    public int getId() {
        return id;
    }

    public SysEntity getSys() {
        return sys;
    }

    public String getBase() {
        return base;
    }

    public WindEntity getWind() {
        return wind;
    }

    public class CoordEntity {
        /**
         * lon : 116.41
         * lat : 39.9
         */
        private double lon;
        private double lat;

        public void setLon(double lon) {
            this.lon = lon;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLon() {
            return lon;
        }

        public double getLat() {
            return lat;
        }
    }

    public class WeatherEntity {
        /**
         * icon : 01d
         * description : 晴
         * main : Clear
         * id : 800
         */
        private String icon;
        private String description;
        private String main;
        private int id;

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getIcon() {
            return icon;
        }

        public String getDescription() {
            return description;
        }

        public String getMain() {
            return main;
        }

        public int getId() {
            return id;
        }
    }

    public class MainEntity {
        /**
         * temp : 299.543
         * temp_min : 299.543
         * grnd_level : 996.39
         * humidity : 25
         * pressure : 996.39
         * sea_level : 1022.5
         * temp_max : 299.543
         */
        private double temp;
        private double temp_min;
        private double grnd_level;
        private int humidity;
        private double pressure;
        private double sea_level;
        private double temp_max;

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public void setTemp_min(double temp_min) {
            this.temp_min = temp_min;
        }

        public void setGrnd_level(double grnd_level) {
            this.grnd_level = grnd_level;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public void setPressure(double pressure) {
            this.pressure = pressure;
        }

        public void setSea_level(double sea_level) {
            this.sea_level = sea_level;
        }

        public void setTemp_max(double temp_max) {
            this.temp_max = temp_max;
        }

        public double getTemp() {
            return temp;
        }

        public double getTemp_min() {
            return temp_min;
        }

        public double getGrnd_level() {
            return grnd_level;
        }

        public int getHumidity() {
            return humidity;
        }

        public double getPressure() {
            return pressure;
        }

        public double getSea_level() {
            return sea_level;
        }

        public double getTemp_max() {
            return temp_max;
        }
    }

    public class CloudsEntity {
        /**
         * all : 0
         */
        private int all;

        public void setAll(int all) {
            this.all = all;
        }

        public int getAll() {
            return all;
        }
    }

    public class SysEntity {
        /**
         * country : China
         * sunrise : 1431550812
         * sunset : 1431602472
         * message : 0.0983
         */
        private String country;
        private int sunrise;
        private int sunset;
        private double message;

        public void setCountry(String country) {
            this.country = country;
        }

        public void setSunrise(int sunrise) {
            this.sunrise = sunrise;
        }

        public void setSunset(int sunset) {
            this.sunset = sunset;
        }

        public void setMessage(double message) {
            this.message = message;
        }

        public String getCountry() {
            return country;
        }

        public int getSunrise() {
            return sunrise;
        }

        public int getSunset() {
            return sunset;
        }

        public double getMessage() {
            return message;
        }
    }

    public class WindEntity {
        /**
         * deg : 195.501
         * speed : 1.3
         */
        private double deg;
        private double speed;

        public void setDeg(double deg) {
            this.deg = deg;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public double getDeg() {
            return deg;
        }

        public double getSpeed() {
            return speed;
        }
    }
}
