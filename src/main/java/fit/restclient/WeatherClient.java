package fit.restclient;

import fit.dto.WeatherResponseDTO;

public interface WeatherClient {
	 
	WeatherResponseDTO fetchWeather(double latitude, double longitude);
	
}
