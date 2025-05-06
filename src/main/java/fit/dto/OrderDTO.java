package fit.dto;

import java.util.List;

public class OrderDTO {
    private String status;
    private Long waiterId;
    private Long tableId;
    private List<Long> itemIds;

    // Getteri i setteri
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Long getWaiterId() { return waiterId; }
    public void setWaiterId(Long waiterId) { this.waiterId = waiterId; }
    public Long getTableId() { return tableId; }
    public void setTableId(Long tableId) { this.tableId = tableId; }
    public List<Long> getItemIds() { return itemIds; }
    public void setItemIds(List<Long> itemIds) { this.itemIds = itemIds; }
}