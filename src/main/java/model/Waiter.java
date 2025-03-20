package model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Waiter {
    
	@Id
	@SequenceGenerator(name = "waiter_sequence",sequenceName = "waiter_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "waiter_sequence")
	private long id;
    private String firstName;
    private String lastName;
    @OneToMany
    private List<RestaurantTable> tables; // One-to-Many veza sa Table
    @OneToMany
    private List<RestaurantOrder> orders;
    
    
    
    public Waiter() {
		super();
	}

	public Waiter(long id, String firstName, String lastName, List<RestaurantTable> tables, List<RestaurantOrder> orders) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.tables = tables;
		this.orders = orders;
	}

	public List<RestaurantOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<RestaurantOrder> orders) {
        this.orders = orders;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<RestaurantTable> getTables() {
        return tables;
    }

    public void setTables(List<RestaurantTable> tables) {
        this.tables = tables;
    }
}