import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WeatherConditions {
    @SerializedName("main")
    public Map<String, Float> measurements = new HashMap<>();
    public String name;
    public int id;

public void display(){
        System.out.println(measurements);
        System.out.println(name);
        System.out.println(id);
    }
}


