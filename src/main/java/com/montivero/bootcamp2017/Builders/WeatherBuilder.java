package com.montivero.bootcamp2017.Builders;

import com.montivero.bootcamp2017.Domains.*;
import org.apache.commons.lang3.text.WordUtils;

/**
 * Created by Daniel on 14/01/2017.
 */
public class WeatherBuilder {

    public State state;
    public ForecastToday today;
    public ForecastExtended[] week;
    public Wind wind;
    public Atmosphere atmosphere;
    public String description;


    public WeatherBuilder state(State state){
        this.state=state;
        return this;
    }

    public WeatherBuilder today(ForecastToday today){
        this.today=today;
        return this;
    }

    public WeatherBuilder week(ForecastExtended[] week){
        this.week=week;
        return this;
    }

    public WeatherBuilder wind(Wind wind){
        this.wind=wind;
        return this;
    }

    public WeatherBuilder atmosphere(Atmosphere atmosphere){
        this.atmosphere=atmosphere;
        return this;
    }

    public WeatherBuilder description(String description){
        this.description= description;
        return this;
    }

    public Weather build(){
        return new Weather(this);
    }

}
