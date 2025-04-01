package fit.service;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import model.RestaurantTable;

@Dependent
public class RestaurantTableService {

	
	@Inject
	EntityManager em;
	
	
	public RestaurantTable addRestaurantTable(RestaurantTable rt) {
		
		return em.merge(rt);
		
	}
}
