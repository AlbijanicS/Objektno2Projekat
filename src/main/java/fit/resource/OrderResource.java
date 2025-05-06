package fit.resource;

import jakarta.ws.rs.core.MediaType;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import fit.service.OrderService;
import fit.dto.OrderDTO;
import model.RestaurantOrder;
import java.util.List;

@Path("orders")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrderResource {

    @Inject
    OrderService orderService;

    @POST
    @Path("create")
    @Transactional
    public Response create(OrderDTO dto) {
        try {
            RestaurantOrder order = orderService.createOrder(dto);
            return Response.ok(order).build();
        } catch (IllegalArgumentException e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("all")
    public Response getAll() {
        List<RestaurantOrder> orders = orderService.getAllOrders();
        return Response.ok(orders).build();
    }
}