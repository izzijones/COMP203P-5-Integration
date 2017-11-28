package ucl.cs;

import org.junit.Test;

import java.time.DayOfWeek;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

public class WeatherDotComTemperatureServiceTest {

    @Test
    public void canRetrieveData(){
        TemperatureService temperatureService = new WeatherDotComTemperatureService();
        int temperature = temperatureService.temperatureFor("London", DayOfWeek.FRIDAY);
        assertThat(temperature, is(greaterThan(-20)));
    }
}
