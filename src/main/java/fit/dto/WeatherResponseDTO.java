package fit.dto;

public class WeatherResponseDTO {
	private CurrentWeatherDTO current_weather;

    public CurrentWeatherDTO getCurrent_weather() {
        return current_weather;
    }

    public void setCurrent_weather(CurrentWeatherDTO current_weather) {
        this.current_weather = current_weather;
    }
}
