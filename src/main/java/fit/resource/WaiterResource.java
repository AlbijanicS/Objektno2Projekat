package fit.resource;


import jakarta.ws.rs.core.MediaType;

import java.util.List;

import fit.service.WaiterService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import model.Waiter;
import jakarta.ws.rs.Produces;

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
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("getAllWaiters")
		public Response getAllWaiters () {
			List<Waiter> waiters = waiterService.getAllWaiters();
			
			return Response.ok().entity(waiters).build();
		}
}
