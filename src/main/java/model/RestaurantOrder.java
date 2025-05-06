package model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.JoinColumn;

@NamedQuery(name = RestaurantOrder.GET_ORDERS_FOR_WAITER, 
query = "SELECT o FROM RestaurantOrder o WHERE o.waiter.id = :waiterId")
@Entity
public class RestaurantOrder {
public static final String GET_ORDERS_FOR_WAITER = "RestaurantOrder.getOrdersForWaiter";
    
    @Id
    @SequenceGenerator(name = "order_sequence", sequenceName = "order_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
    private Long id;
    private String status; 
    
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "order_menuitem",
               joinColumns = @JoinColumn(name = "order_id"),
               inverseJoinColumns = @JoinColumn(name = "menuitem_id"))
    private List<MenuItem> menuItems;
    
    @ManyToOne
    private RestaurantTable table;
    
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((table == null) ? 0 : table.hashCode());
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
        RestaurantOrder other = (RestaurantOrder) obj;
        
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
            
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
            
        if (table == null) {
            if (other.table != null)
                return false;
        } else if (!table.equals(other.table))
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
        return "RestaurantOrder [id=" + id + ", status=" + status + 
               ", table=" + (table != null ? table.getId() : "null") + 
               ", waiter=" + (waiter != null ? waiter.getId() : "null") + "]";
    }
}
