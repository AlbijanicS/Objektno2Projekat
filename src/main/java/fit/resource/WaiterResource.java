package fit.resource;


import jakarta.ws.rs.core.MediaType;
import fit.service.WaiterService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import model.Waiter;

@Path("waiter")
public class WaiterResource {

		@Inject
		WaiterService waiterService;
		
		@Path("addWaiter")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Transactional
		public Response addWaiter(Waiter w) {
			Waiter waiter = waiterService.addWaiter(w);
			
			return Response.ok(waiter).build();
		}
}
