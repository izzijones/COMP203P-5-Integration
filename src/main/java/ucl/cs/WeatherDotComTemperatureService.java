package ucl.cs;

import com.weather.Day;
import com.weather.Forecaster;
import com.weather.Region;

import java.time.DayOfWeek;

public class WeatherDotComTemperatureService implements TemperatureService {
    @Override
    public int temperatureFor(String place, DayOfWeek day) {
        return new Forecaster().forecastFor(Region.valueOf(place.toUpperCase()), Day.valueOf(day.name().toUpperCase())).temperature();
    }
}
