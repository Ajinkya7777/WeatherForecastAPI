# Weather API Integration with Spring Boot

This project demonstrates the integration of the Weather API from Rapid API using SPring Boot. It includes Restful APIs
for retrieving weather forecast summary and hourly details for a given city.

## Pre-requisites
  - Java 11
  - Maven
  - Spring Boot 3

## Build Project 
   mvn clean install
   
## Run the application
   mvn spring-boot:run
   
## Access the APIs locally
  1. Weather Forecast Summary:
     Endpoint : http://localhost:8080/weather/hourlyDetails?city=Berlin 
  2. Weather Forecast hourly details:
     Endpoint : http://localhost:8080/weather/summary?city=Berlin
      
## Configuration
   The base URL for Rapid API are configured in `src/main/resources/application.properties`.
   Additional configuration for WebClient is done in the `SpringConfig` class.