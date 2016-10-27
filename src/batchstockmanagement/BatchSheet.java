package batchstockmanagement;

import java.util.ArrayList;

/**
 *
 * @author Joshua Coombes-Hall
 */
public class BatchSheet 
{
    private String batchSheetID;
    private String outputName;
    private SystemUser creator;
    private ArrayList<StockItem> ingredients;
    private ArrayList<String> instructions;
    private String outputType; //Either Finished Product, or Ingredient.
    //Change this to an actual date at some stage.
    private String creationDate;
    
    public BatchSheet(String batchSheetID, String outputName, SystemUser creator, ArrayList<StockItem> ingredients, ArrayList<String> instructions, String outputType, String creationDate)
    {
        this.batchSheetID = batchSheetID;
        this.outputName = outputName;
        this.creator = creator;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.outputType = outputType;
        this.creationDate = creationDate;
    }
    
    //Getters
    public String getBatchSheetID()
    {
        return batchSheetID;
    }
    
    public String getName()
    {
        return outputName;
    }
    
    public SystemUser getCreator()
    {
        return creator;
    }
    
    public ArrayList<StockItem> getIngredients()
    {
        return ingredients;
    }
    
    public ArrayList<String> getInstructions()
    {
        return instructions;
    }
    
    public String getOutputType()
    {
        return outputType;
    }
    
    //Setters
    public void setName(String newName)
    {
        outputName = newName;
    }
    
    public void setOutputType(String newType)
    {
        outputType = newType;
    }
    
    //Instructions
    public void AddInstruction(String newInstruction, int position)
    {
        instructions.add(position, newInstruction);
    }
    
    public void RemoveInstruction(int position)
    {
        instructions.remove(position);
    }
    
    public void ReplaceInstruction(String newInstruction, int position)
    {
        RemoveInstruction(position);
        AddInstruction(newInstruction, position);
    }
    
    //Ingredients
    public void AddIngredient(StockItem newIngredient)
    {
        ingredients.add(newIngredient);
    }
    
    public void RemoveIngredient(StockItem ingredientToRemove)
    {
        ingredients.remove(ingredientToRemove);
    }
    
    public void ReplaceIngredient(StockItem ingredientToReplace, StockItem newIngredient)
    {
        for(int i = 0; i < ingredients.size(); i++)
        {
            if(ingredients.get(i).getStockID().equals(ingredientToReplace.getStockID()))
            {
                ingredients.set(i, newIngredient);
            }
        }
    }
}
