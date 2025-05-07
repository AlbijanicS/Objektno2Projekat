package fit.service;
import fit.restclient.WeatherClient;
import fit.dto.CurrentWeatherDTO;
import fit.dto.WeatherResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.WeatherRecord;

@ApplicationScoped
public class WeatherService {

    @Inject
    WeatherClient weatherClient;

    @Inject
    EntityManager em;

    @Transactional
    public WeatherRecord getAndSaveWeather(double latitude, double longitude) {
        WeatherResponseDTO response = weatherClient.fetchWeather(latitude, longitude);
        CurrentWeatherDTO current = response.getCurrent_weather();

        WeatherRecord record = new WeatherRecord();
        record.setTemperature(current.getTemperature());
        record.setWindspeed(current.getWindspeed());
        record.setLatitude(latitude);
        record.setLongitude(longitude);
        record.setTime(current.getTime());

        em.persist(record);
        return record;
    }
}