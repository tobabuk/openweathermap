package bukiet.weather;

import com.andrewoid.apikeys.ApiKey;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.Callable;

public class WeatherReport {
    ApiKey apiKey = new ApiKey();
    String keyString = apiKey.get();
    private WeatherService service;
    String name;
    double temp;

    public WeatherReport(WeatherService service) {
        this.service = service;
    }


    public void weatherNow() {
        WeatherResponse response = service.weatherNow("Boston", keyString, "imperial").blockingGet();
        this.name = response.name;
        this.temp = response.main.temp;

    }


}
