package com.task.weatherForecast.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.task.weatherForecast.service.WeatherService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    /**
     * returns weather summary on the basis of location name
     * @param clientId
     * @param clientSecret
     * @param city
     * @return
     * @throws IOException
     */
    @GetMapping("/summary")
    public ResponseEntity<JsonNode> getWeatherSummary(
            @RequestHeader(value = "forecast.client-id") String clientId,
            @RequestHeader(value = "forecast.client-secret") String clientSecret,
            @RequestParam String city) throws IOException {
        JsonNode summary = weatherService.getWeatherSummary(city, clientId, clientSecret);
        return ResponseEntity.ok(summary);
    }

    /**
     * returns weather hourly details on the basis of location name
     * @param clientId
     * @param clientSecret
     * @param city
     * @return
     * @throws IOException
     */
    @GetMapping("/hourlyDetails")
    public ResponseEntity<JsonNode> getHourlyWeatherDetails(
            @RequestHeader(value = "forecast.client-id") String clientId,
            @RequestHeader(value = "forecast.client-secret") String clientSecret,
            @RequestParam String city) throws IOException {
        JsonNode hourlyDetails = weatherService.getHourlyWeatherDetails(city, clientId, clientSecret);
        return ResponseEntity.ok(hourlyDetails);
    }
}
