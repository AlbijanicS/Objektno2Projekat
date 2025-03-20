package model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class RestaurantTable {
    
	@Id
	@SequenceGenerator(name = "table_sequence",sequenceName = "table_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "table_sequence")
	private long id;
    private int tableNumber;
    private String status; // npr. "zauzet", "slobodan"
    
    @ManyToOne
    private Waiter waiter; // Many-to-One veza sa Waiter
    @OneToMany
    private List<RestaurantOrder> orders; // One-to-Many veza sa Order

    
    public RestaurantTable() {
		super();
	}


	public RestaurantTable(long id, int tableNumber, String status, Waiter waiter) {
		super();
		this.id = id;
		this.tableNumber = tableNumber;
		this.status = status;
		this.waiter = waiter;
	}


	public long getId() {
        return id;
    }

    
    public void setId(long id) {
        this.id = id;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public List<RestaurantOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<RestaurantOrder> orders) {
        this.orders = orders;
    }
}
