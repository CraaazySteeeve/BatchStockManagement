package batchstockmanagement;

/**
 *
 * @author Joshua Coombes-Hall
 */
public abstract class StockItem 
{
    private String stockID;
    private String name;
    private int quantity;
    private String unit;
    private String location;
    //Something to handle the dates.
    private String addedDate;
    private String expiryDate;
    public StockItem(String stockID, String name, int quantity, String unit, String addedDate, String expiryDate)
    {
        this.stockID = stockID;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.addedDate = addedDate;
        this.expiryDate = expiryDate;
    }
    
    public void updateQuantity(int change)
    {
        quantity += change;
    }
    
    //Getters
    public String getStockID()
    {
        return stockID;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
    public String getUnit()
    {
        return unit;
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
    public void setName(String newName)
    {
        name = newName;
    }
    
    public void setQuantity(int newQuantity)
    {
        quantity = newQuantity;
    }
    
    public void setUnit(String newUnit)
    {
        unit = newUnit;
    }
    
    public void setLocation(String newLocation)
    {
        location = newLocation;
    }
}
