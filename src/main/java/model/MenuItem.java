package model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class MenuItem {
   
	@Id
	@SequenceGenerator(name = "menuItem_sequence",sequenceName = "menuItem_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menuItem_sequence")
	private long id;
    private String name;
    private String description;
    private double price;
    
    @ManyToMany
    private List<RestaurantOrder> orders; // Many-to-Many veza sa Order

   
    
    
    public MenuItem() {
		super();
	}

	public MenuItem(long id, String name, String description, double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<RestaurantOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<RestaurantOrder> orders) {
        this.orders = orders;
    }
}