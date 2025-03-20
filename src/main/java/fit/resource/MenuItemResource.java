package fit.resource;

import jakarta.ws.rs.core.MediaType;

import fit.service.MenuItemService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import model.MenuItem;

@Path("menuitem")
public class MenuItemResource {

	@Inject
	MenuItemService menuItemService;
	
	@Path("addMenuItem")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Response addMenuItem(MenuItem mi) {
		
		MenuItem menuItem = menuItemService.addMenuItem(mi);
		
		return Response.ok(menuItem).build();
	}
	
}
