package fit.resource;

import fit.service.RestaurantTableService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.RestaurantTable;

@Path("RestaurantTable")
public class RestaurantTableResource {

	@Inject
	RestaurantTableService restaurantTableService;
	
	@Path("addRestaurantTable")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Response addRestaurantTable(RestaurantTable rt) {
		
		RestaurantTable restaurantTable = restaurantTableService.addRestaurantTable(rt);
		
		return Response.ok(restaurantTable).build();
	}
}
