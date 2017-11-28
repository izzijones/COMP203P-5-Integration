package ucl.cs;

import java.time.DayOfWeek;

public interface TemperatureService {
    int temperatureFor(String place, DayOfWeek day);
}
