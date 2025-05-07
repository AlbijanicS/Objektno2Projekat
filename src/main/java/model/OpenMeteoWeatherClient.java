package model;
import fit.dto.WeatherResponseDTO;
import fit.restclient.WeatherClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
public class OpenMeteoWeatherClient implements WeatherClient {

    private static final String BASE_URL = "https://api.open-meteo.com/v1/forecast";

    @Override
    public WeatherResponseDTO fetchWeather(double latitude, double longitude) {
        var client = ClientBuilder.newClient();
        return client
                .target(BASE_URL)
                .queryParam("latitude", latitude)
                .queryParam("longitude", longitude)
                .queryParam("current_weather", "true")
                .request(MediaType.APPLICATION_JSON)
                .get(WeatherResponseDTO.class);
    }
}
