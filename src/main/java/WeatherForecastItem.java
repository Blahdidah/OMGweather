import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WeatherForecastItem {

    public Map<String, Float> main;
    WeatherWind wind = new WeatherWind();
    public List<WeatherDescription> weather;
    public String dt_txt;

    public List<WeatherDescription> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherDescription> weather) {
        this.weather = weather;
    }
}
