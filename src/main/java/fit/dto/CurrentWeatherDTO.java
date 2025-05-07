package fit.dto;

public class CurrentWeatherDTO {
	 private double temperature;
	    private double windspeed;
	    private String time;

	    public double getTemperature() {
	        return temperature;
	    }

	    public void setTemperature(double temperature) {
	        this.temperature = temperature;
	    }

	    public double getWindspeed() {
	        return windspeed;
	    }

	    public void setWindspeed(double windspeed) {
	        this.windspeed = windspeed;
	    }

	    public String getTime() {
	        return time;
	    }

	    public void setTime(String time) {
	        this.time = time;
	    }
}
