package fit.resource;

import fit.service.MenuItemService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.MenuItem;

import java.util.List;

@Path("menu")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MenuItemResource {

    @Inject
    MenuItemService menuItemService;

    @POST
    @Path("create")
    @Transactional
    public Response create(MenuItem item) {
        MenuItem created = menuItemService.create(item);
        return Response.ok(created).build();
    }

    @GET
    @Path("all")
    public Response getAll() {
        List<MenuItem> items = menuItemService.getAll();
        return Response.ok(items).build();
    }
}
