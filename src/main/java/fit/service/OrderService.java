package fit.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.RestaurantOrder;
import model.MenuItem;
import model.RestaurantTable;
import model.Waiter;
import fit.dto.OrderDTO;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
public class OrderService {

    @Inject
    EntityManager em;

    @Transactional
    public RestaurantOrder createOrder(OrderDTO dto) {
        RestaurantOrder order = new RestaurantOrder();
        order.setStatus(dto.getStatus());

        
        Waiter waiter = dto.getWaiterId() != null ? em.find(Waiter.class, dto.getWaiterId()) : null;
        if (waiter == null) {
            throw new IllegalArgumentException("Waiter with ID " + dto.getWaiterId() + " not found.");
        }
        order.setWaiter(waiter);

       
        RestaurantTable table = dto.getTableId() != null ? em.find(RestaurantTable.class, dto.getTableId()) : null;
        if (table == null) {
            throw new IllegalArgumentException("Table with ID " + dto.getTableId() + " not found.");
        }
        order.setTable(table);

        
        List<MenuItem> items = dto.getItemIds().stream()
            .map(id -> em.find(MenuItem.class, id))
            .filter(item -> item != null)
            .collect(Collectors.toList());
        if (items.isEmpty()) {
            throw new IllegalArgumentException("No valid MenuItem IDs provided.");
        }
        order.setMenuItems(items);

        
        em.merge(order);

        
        for (MenuItem item : items) {
            item.getOrders().add(order);
            em.merge(item);
        }

        return order;
    }

    public List<RestaurantOrder> getAllOrders() {
        return em.createQuery("SELECT o FROM RestaurantOrder o", RestaurantOrder.class).getResultList();
    }
}