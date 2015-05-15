package com.pgq.simpleweather.Bean;

/**
 * Created by PGQ on 2015-5-15-0015.
 */
public class CurrentWeatherError {

    /**
     * cod : 404
     * message : Error: Not found city
     */
    private String cod;
    private String message;

    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCod() {
        return cod;
    }

    public String getMessage() {
        return message;
    }
}
