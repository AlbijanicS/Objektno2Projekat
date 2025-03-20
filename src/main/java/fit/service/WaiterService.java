package fit.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import model.Waiter;

@Dependent
public class WaiterService {

	@Inject
	EntityManager em;
	
	public Waiter addWaiter(Waiter w) {
		
		return em.merge(w);
	}
	
}
