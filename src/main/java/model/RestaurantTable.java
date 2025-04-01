package model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = RestaurantTable.GET_TABLES_FOR_WAITER, 
query = "SELECT t FROM RestaurantTable t WHERE t.waiter.id = :waiterId")
public class RestaurantTable {
    
public static final String GET_TABLES_FOR_WAITER = "RestaurantTable.getTablesForWaiter";
    
    @Id
    @SequenceGenerator(name = "table_sequence", sequenceName = "table_sequence", allocationSize = 1)
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));  // For long
        result = prime * result + tableNumber;
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((waiter == null) ? 0 : waiter.hashCode());
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
        RestaurantTable other = (RestaurantTable) obj;
        
        if (id != other.id)  // Direct comparison for long
            return false;
            
        if (tableNumber != other.tableNumber)
            return false;
            
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
            
        if (waiter == null) {
            if (other.waiter != null)
                return false;
        } else if (!waiter.equals(other.waiter))
            return false;
            
        return true;
    }

    @Override
    public String toString() {
        return "RestaurantTable [id=" + id + ", tableNumber=" + tableNumber + 
               ", status=" + status + ", waiter=" + 
               (waiter != null ? waiter.getId() : "null") + "]";
    }
}
