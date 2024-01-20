package com.task.weatherForecast.service;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;

public interface WeatherService {

    JsonNode getWeatherSummary(String city, String clientId, String clientSecret) throws IOException;

    JsonNode getHourlyWeatherDetails(String city, String clientId, String clientSecret) throws IOException;
}
