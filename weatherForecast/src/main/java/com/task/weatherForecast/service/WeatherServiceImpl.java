package com.task.weatherForecast.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WeatherServiceImpl implements WeatherService{

    @Autowired
    private WebClient webClient;

    @Value("${forecast.base-url}")
    private String baseUrl;

    @Override
    public JsonNode getWeatherSummary(String city, String clientId, String clientSecret) {
        webClient = WebClient.builder().baseUrl(baseUrl)
                .defaultHeader("X-RapidAPI-Key", clientId)
                .defaultHeader("X-RapidAPI-Host", clientSecret)
                .build();
        String uri = baseUrl + city + "/summary/";
        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(JsonNode.class)
                .block();
    }

    @Override
    public JsonNode getHourlyWeatherDetails(String city, String clientId, String clientSecret) {
        webClient = WebClient.builder().baseUrl(baseUrl)
                .defaultHeader("X-RapidAPI-Key", clientId)
                .defaultHeader("X-RapidAPI-Host", clientSecret)
                .build();
        String uri = baseUrl + city + "/hourly/";
        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(JsonNode.class)
                .block();
    }
}
