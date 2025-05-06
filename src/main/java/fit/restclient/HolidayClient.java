package fit.restclient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import fit.dto.CountryDTO;
import fit.dto.HolidayDTO;
import java.util.List;

@Path("/api/v3")
@RegisterRestClient(configKey = "holiday-api")
public interface HolidayClient {

    @GET
    @Path("/AvailableCountries")
    @Produces(MediaType.APPLICATION_JSON)
    List<CountryDTO> getAvailableCountries();

    @GET
    @Path("/NextPublicHolidays/{countryCode}")
    @Produces(MediaType.APPLICATION_JSON)
    List<HolidayDTO> getNextPublicHolidays(@PathParam("countryCode") String countryCode);
}