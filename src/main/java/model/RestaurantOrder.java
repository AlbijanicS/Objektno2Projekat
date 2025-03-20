package model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class RestaurantOrder {
    
	@Id
	@SequenceGenerator(name = "order_sequence",sequenceName = "order_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
	private Long id;
    private String status; 
    
    @ManyToMany
    private List<MenuItem> menuItems; // Many-to-Many veza sa MenuItem
    
    @ManyToOne
    private RestaurantTable table; // Many-to-One veza sa Table
    
    @ManyToOne
    private Waiter waiter;
    
    
    
    public RestaurantOrder() {
		super();
	}

	public RestaurantOrder(Long id, String status, List<MenuItem> menuItems, RestaurantTable table, Waiter waiter) {
		super();
		this.id = id;
		this.status = status;
		this.menuItems = menuItems;
		this.table = table;
		this.waiter = waiter;
	}

	public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public RestaurantTable getTable() {
        return table;
    }

    public void setTable(RestaurantTable table) {
        this.table = table;
    }
}
