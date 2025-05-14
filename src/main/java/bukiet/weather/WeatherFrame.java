package bukiet.weather;

import javax.swing.*;
import java.awt.*;

public class WeatherFrame extends JFrame {

    public WeatherFrame() {
        setTitle("Weather Report");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        WeatherServiceFactory factory = new WeatherServiceFactory();
        WeatherService service = factory.getService();
        WeatherReport weather = new WeatherReport(service);
        weather.weatherNow();
        JLabel nameLabel = new JLabel("City: " + weather.name);
        JLabel tempLabel = new JLabel("Temp: " + weather.temp);
        setLayout(new GridLayout(2, 1));
        add(nameLabel);
        add(tempLabel);
    }

    public static void main(String[] args) {
        new WeatherFrame().setVisible(true);


    }

}