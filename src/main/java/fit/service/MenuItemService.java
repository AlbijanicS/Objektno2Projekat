package fit.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.MenuItem;

import java.util.List;

@Dependent
public class MenuItemService {

    @Inject
    EntityManager em;

    @Transactional
    public MenuItem create(MenuItem item) {
        em.persist(item);
        return item;
    }

    public List<MenuItem> getAll() {
        return em.createQuery("SELECT m FROM MenuItem m", MenuItem.class).getResultList();
    }
}