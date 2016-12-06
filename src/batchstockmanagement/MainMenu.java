package batchstockmanagement;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Joshua-Coombes-Hall
 */
public class MainMenu extends Menu 
{

    GridPane mainMenuContent;
    Button batchSheetSearchButton;
    Button ingredientsSearchButton;
    Button viewWarehouseButton;
    Button adminSettingsButton;
    
    public MainMenu(MenuManager menuManager)
    {
        super(menuManager);
    }
    
    @Override
    public void initMenu()
    {
        mainMenuContent = new GridPane();
        mainMenuContent.getStyleClass().add("centredWindow");
        mainMenuContent.setHgap(10);
        mainMenuContent.setVgap(20);
        
        
        batchSheetSearchButton = new Button("Search Batch Sheets");
        batchSheetSearchButton.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent e) 
            {
                //getMenuManager().showMenu(getMenuManager().mainMenu);
            }
        });
        mainMenuContent.add(batchSheetSearchButton, 0, 0);
        
        ingredientsSearchButton = new Button("Search Ingredients");
        ingredientsSearchButton.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent e) 
            {
                //getMenuManager().showMenu(getMenuManager().mainMenu);
            }
        });
        mainMenuContent.add(ingredientsSearchButton, 0, 1);
        
        viewWarehouseButton = new Button("View Warehouse");
        viewWarehouseButton.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent e) 
            {
                //getMenuManager().showMenu(getMenuManager().mainMenu);
            }
        });
        mainMenuContent.add(viewWarehouseButton, 0, 2);
        
        adminSettingsButton = new Button("Admin Settings");
        adminSettingsButton.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent e) 
            {
                //getMenuManager().showMenu(getMenuManager().mainMenu);
            }
        });
        mainMenuContent.add(adminSettingsButton, 0, 3);
        
        getPane().add(mainMenuContent, 0, 0);
    }
    
    @Override
    public void onMenuEntry()
    {

    }
    
    @Override
    public void onMenuExit()
    {
        
    }
}
