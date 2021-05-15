import com.google.gson.Gson;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import static java.net.URLEncoder.encode;

public class Main {


    public static String urlWeather = "https://api.openweathermap.org/data/2.5/weather?";
    public static String urlForecast = "https://api.openweathermap.org/data/2.5/forecast?";
    String charset = "UTF-8";
    String apikey = "fbf9e6a1eb5fd0066343800226bc9572";
    //String param2;

    public static void main(String[] args) throws IOException {

        Gson gson = new Gson();
        Main main = new Main();
        WeatherForecast fc = new WeatherForecast();
        String city = main.request();
        //String responseBody = main.hades(city, urlWeather);
        String responseHead = main.hades(city, urlForecast);


        //WeatherConditions wc = new WeatherConditions();
        //WeatherForecastItem wfi = new WeatherForecastItem();

        //WeatherConditions results = gson.fromJson(responseBody, WeatherConditions.class);
        WeatherForecast forecast = gson.fromJson(responseHead, WeatherForecast.class);
        //WeatherForecastItem item = gson.fromJson(, WeatherForecastItem.class);

        //results.display();


    }
    public String hades(String city, String url) throws IOException {
        String query = String.format("q=%s&apikey=%s&units=imperial",
                encode(city, charset),
                encode(apikey, charset));

        URLConnection connection = new URL(url + query).openConnection();
        connection.setRequestProperty("Accept-Charset", charset);
                InputStream response = connection.getInputStream();
        try (Scanner scanner = new Scanner(response)){
            String responseBody = scanner.useDelimiter("\\A").next();
            return responseBody;

        }

    }
    public String request(){
        //asking for a city for pulling weather information
        Scanner cityToken = new Scanner(System.in);
        System.out.println("City for forecast:");
        String city = cityToken.nextLine();
        return city;

    }
}



