package batchstockmanagement;

import java.util.ArrayList;

/**
 *
 * @author Joshua Coombes-Hall
 */
public class StockItem 
{
    private String stockID;
    private String name;
    private String unit;
    private ArrayList<StockItem> replacementIngredients;
    private String stockType; //Either "Finished Product", or "Ingredient"
    private BatchSheet batchSheetToMake;
    public StockItem(String stockID, String name, String unit, String stockType)
    {
        this.stockID = stockID;
        this.name = name;
        this.unit = unit;
        this.stockType = stockType;
        this.batchSheetToMake = null;
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
    
    public String getStockType()
    {
        return stockType;
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
    
    public void setBatchSheet(BatchSheet thisItemsBatchSheet)
    {
        this.batchSheetToMake = thisItemsBatchSheet;
    }
    
    public void addReplacementIngredient(StockItem replacementIngredient)
    {
        replacementIngredients.add(replacementIngredient); //THIS WILL NEED TO ADD THE INGREDIENT TO ALL REPLACEMENT INGREDIENTS THIS ITEM HAS.
    }
}
