package model;

import java.util.List;

public class Order {
    
	private Long id;
    private String status; // npr. "u pripremi", "završeno"
    private List<MenuItem> menuItems; // Many-to-Many veza sa MenuItem
    private Table table; // Many-to-One veza sa Table
    private Waiter waiter;
    
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

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
