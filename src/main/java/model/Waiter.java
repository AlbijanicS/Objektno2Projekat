package model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;


@Entity
@NamedQuery(name = Waiter.GET_ALL_WAITERS, query = "Select w from Waiter w")
public class Waiter {
    
	public static final String GET_ALL_WAITERS = "Waiter.getAllWaiters";
	
	@Id
	@SequenceGenerator(name = "waiter_sequence",sequenceName = "waiter_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "waiter_sequence")
	private long id;
    private String firstName;
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "waiter_id")
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

    public void setRestaurantTables(List<RestaurantTable> tables) {
        this.tables = tables;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));  // For long
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((tables == null) ? 0 : tables.hashCode());
        result = prime * result + ((orders == null) ? 0 : orders.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Waiter other = (Waiter) obj;
        
        if (id != other.id)  // For primitive long, we can compare directly
            return false;
        
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
            
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
            
        if (tables == null) {
            if (other.tables != null)
                return false;
        } else if (!tables.equals(other.tables))
            return false;
            
        if (orders == null) {
            if (other.orders != null)
                return false;
        } else if (!orders.equals(other.orders))
            return false;
            
        return true;
    }
}