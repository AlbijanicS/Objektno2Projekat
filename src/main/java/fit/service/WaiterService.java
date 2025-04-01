package fit.service;

import java.util.ArrayList;
import java.util.List;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.RestaurantOrder;
import model.RestaurantTable;
import model.Waiter;

@Dependent
public class WaiterService {

	@Inject
	EntityManager em;
	
	public Waiter addWaiter(Waiter w) {
		
		return em.merge(w);
	}
	
	@Transactional
	public List<Waiter> getAllWaiters() {
	    List<Waiter> waiters = em.createNamedQuery(Waiter.GET_ALL_WAITERS, Waiter.class).getResultList();
	    
	    for (Waiter waiter : waiters) {
	        
	        List<RestaurantTable> tables = em.createNamedQuery("RestaurantTable.getTablesForWaiter", RestaurantTable.class)
	                .setParameter("waiterId", waiter.getId())
	                .getResultList();
	        
	       
	        List<RestaurantOrder> orders = em.createNamedQuery("RestaurantOrder.getOrdersForWaiter", RestaurantOrder.class)
	                .setParameter("waiterId", waiter.getId())
	                .getResultList();
	        
	        waiter.setRestaurantTables(new ArrayList<>(tables));
	        waiter.setOrders(new ArrayList<>(orders));
	    }

	    return waiters;
	}

}
