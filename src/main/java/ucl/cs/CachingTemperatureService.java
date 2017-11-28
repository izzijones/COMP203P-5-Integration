package ucl.cs;


import java.time.DayOfWeek;
import java.util.LinkedHashMap;
import java.util.Map;

public class CachingTemperatureService implements TemperatureService {
    private TemperatureService downstream;
    private Map<Pair<String,DayOfWeek>,Integer> cache;

    public CachingTemperatureService(TemperatureService downstream) {
        this(downstream, 1000);

    }

    public CachingTemperatureService(TemperatureService downstream, int capacity){
        cache = new LinkedHashMap<Pair<String,DayOfWeek>,Integer>(){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
        this.downstream = downstream;
        }


    @Override
    public int temperatureFor(String place, DayOfWeek dayOfWeek) {
        Pair<String, DayOfWeek> key = new Pair<>(place, dayOfWeek);
        if(!cache.containsKey(key)){
            cache.put(key,downstream.temperatureFor(place, dayOfWeek));
        }
        return cache.get(key);
    }
}

