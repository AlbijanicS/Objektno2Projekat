package fit.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import model.MenuItem;

@Dependent
public class MenuItemService {

	
	@Inject
	EntityManager em;
	
	public MenuItem addMenuItem(MenuItem mi) {
		
		return em.merge(mi);
		
	}
}
