package batchstockmanagement;

/**
 *
 * @author Joshua Coombes-Hall
 */
public class StockItem 
{
    private String stockID;
    private String name;
    private String unit;
    public StockItem(String stockID, String name, String unit)
    {
        this.stockID = stockID;
        this.name = name;
        this.unit = unit;
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
    
    public String getUnit()
    {
        return unit;
    }
    
    //Setters
    public void setName(String newName)
    {
        name = newName;
    }

    public void setUnit(String newUnit)
    {
        unit = newUnit;
    }
}
