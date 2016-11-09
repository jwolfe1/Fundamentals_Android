package com.JasonWolfe.Week_11;

import java.util.*;

interface WeatherDataSource {
    public void addListener(WeatherDataListener listener);
    public void update();
}

interface WeatherDataListener {
    public void update(WeatherData data);
}

abstract class WeatherData {
    private String dataType;
    private Double measuredValue;

    WeatherData(String dataType, double measuredValue) {
        this.dataType = dataType;
        this.measuredValue = measuredValue;
    }

    public String getDataType() {
        return dataType;
    }

    public Double getMeasuredValue() {
        return measuredValue;
    }

    abstract public String getUpdateMessage();
}

class TemperatureSensor implements WeatherDataSource {
    private List<WeatherDataListener> listeners = new ArrayList<>();
    private double temperature;

    TemperatureSensor() {
        updateTemperature();
    }

    public double getTemperature() {
        return temperature;
    }

    private void updateTemperature() {
        temperature = new Random().nextDouble() * 100;
    }

    @Override
    public void addListener(WeatherDataListener listener) {
        listeners.add(listener);
    }

    @Override
    public void update() {
        System.out.println("TemperatureSensor: getting new data.");
        updateTemperature();
        for (WeatherDataListener listener : listeners) {
            listener.update(new WeatherData("temperature", temperature) {
                @Override
                public String getUpdateMessage() {
                    return "The new temperature is " + getMeasuredValue();
                }
            });
        }

    }
}

class HumiditySensor implements WeatherDataSource {
    private List<WeatherDataListener> listeners = new ArrayList<>();
    private double humidity;

    HumiditySensor() {
        updateHumidity();
    }

    public double getHumidity() {
        return humidity;
    }

    private void updateHumidity() {
        humidity = new Random().nextDouble() * 100;
    }

    @Override
    public void addListener(WeatherDataListener listener) {
        listeners.add(listener);
    }

    @Override
    public void update() {
        System.out.println("HumiditySensor: getting new data.");
        updateHumidity();
        for (WeatherDataListener listener : listeners) {
            listener.update(new WeatherData("humidity", humidity) {
                @Override
                public String getUpdateMessage() {
                    return "The new humidity is " + getMeasuredValue();
                }
            });
        }

    }
}

class PressureSensor implements WeatherDataSource {
    private List<WeatherDataListener> listeners = new ArrayList<>();
    private double pressure;

    PressureSensor() {
        updatePressure();
    }

    public double getPressure() {
        return pressure;
    }

    private void updatePressure() {
        pressure = new Random().nextDouble() * 100;
    }

    @Override
    public void addListener(WeatherDataListener listener) {
        listeners.add(listener);
    }

    @Override
    public void update() {
        System.out.println("PressureSensor: getting new data.");
        updatePressure();
        for (WeatherDataListener listener : listeners) {
            listener.update(new WeatherData("pressure", pressure) {
                @Override
                public String getUpdateMessage() {
                    return "The new pressure is " + getMeasuredValue();
                }
            });
        }

    }
}

class WeatherStation implements WeatherDataListener {
    private Map<String, Double> weatherData = new HashMap<>();
    private List<String> log = new ArrayList<>();

    @Override
    public void update(WeatherData newData) {
        System.out.println("WeatherStation: Updating the weather station data with new "
                + newData.getDataType() + " data.");
        weatherData.put(newData.getDataType(), newData.getMeasuredValue());
        log.add(newData.getUpdateMessage());
    }

    public void displayCurrentWeather() {
        System.out.println("Weather Report");
        for (String dataType: weatherData.keySet()) {
            System.out.println(dataType + ": " + weatherData.get(dataType));
        }
    }

    public void displayLog() {
        for (int i=0; i < log.size(); i++) {
            int currentLine = i + 1;
            System.out.println(currentLine + ": " + log.get(i));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        WeatherStation localWeatherStation = new WeatherStation();

        TemperatureSensor temperatureSensor = new TemperatureSensor();
        HumiditySensor humiditySensor = new HumiditySensor();
        PressureSensor pressureSensor = new PressureSensor();

        temperatureSensor.addListener(localWeatherStation);
        humiditySensor.addListener(localWeatherStation);
        pressureSensor.addListener(localWeatherStation);

        System.out.println("Main: simulating updates from sensors");
        temperatureSensor.update();
        humiditySensor.update();
        pressureSensor.update();

        System.out.println("Main: displaying report and logs");
        localWeatherStation.displayCurrentWeather();
        localWeatherStation.displayLog();
    }
}