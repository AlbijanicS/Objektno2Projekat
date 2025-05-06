package fit.resource;

import jakarta.ws.rs.core.MediaType;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import fit.service.HolidayService;
import fit.dto.CountryDTO;
import model.Holiday;
import java.util.List;

@Path("holidays")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HolidayResource {

    @Inject
    HolidayService holidayService;

    @GET
    @Path("available")
    public Response getAvailableCountries() {
        List<CountryDTO> countries = holidayService.getAvailableCountries();
        return Response.ok(countries).build();
    }

    @GET
    @Path("next/{countryCode}")
    @Transactional
    public Response getNextPublicHolidays(@PathParam("countryCode") String countryCode) {
        try {
            List<Holiday> holidays = holidayService.getNextPublicHolidays(countryCode);
            return Response.ok(holidays).build();
        } catch (Exception e) {
            return Response.status(400).entity("Error fetching holidays: " + e.getMessage()).build();
        }
    }
}