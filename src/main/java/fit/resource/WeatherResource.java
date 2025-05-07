package fit.resource;


import fit.service.WeatherService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.WeatherRecord;

@Path("/weather")
@Produces(MediaType.APPLICATION_JSON)
public class WeatherResource {

    @Inject
    WeatherService weatherService;

    @GET
    @Path("/save")
    public Response saveWeather(@QueryParam("lat") double lat, @QueryParam("lon") double lon) {
        WeatherRecord saved = weatherService.getAndSaveWeather(lat, lon);
        return Response.ok(saved).build();
    }
}