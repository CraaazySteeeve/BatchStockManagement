package batchstockmanagement;

/**
 *
 * @author Joshua Coombes-Hall
 */
public abstract class StockInstance extends StockItem
{
    private String instanceID;
    private int quantity;
    private String location;
    //Something to handle the dates.
    private String addedDate;
    private String expiryDate;
    public StockInstance(String stockID, String name, String unit, int quantity, String addedDate, String expiryDate, String location)
    {
        super(stockID, name, unit);
        this.quantity = quantity;
        this.addedDate = addedDate;
        this.expiryDate = expiryDate;
        this.location = location;
    }
    
    public StockInstance(StockItem originItem, int quantity, String addedDate, String expiryDate, String location)
    {
        super(originItem.getStockID(), originItem.getName(), originItem.getUnit());
        this.quantity = quantity;
        this.addedDate = addedDate;
        this.expiryDate = expiryDate;
        this.location = location;
    }
    
    public void updateQuantity(int change)
    {
        quantity += change;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
    public String getLocation()
    {
        return location;
    }
    
    public String getAddedDate()
    {
        return addedDate;
    }
    
    public String getExpiryDate()
    {
        return expiryDate;
    }
    
    //Setters
    
    public void setQuantity(int newQuantity)
    {
        quantity = newQuantity;
    }
    
    public void setLocation(String newLocation)
    {
        location = newLocation;
    }
}
