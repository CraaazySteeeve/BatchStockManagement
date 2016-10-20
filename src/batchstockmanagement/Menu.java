package batchstockmanagement;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Joshua Coombes-Hall
 */
public abstract class Menu 
{
    private final int screenWidth = 300, screenHeight = 400;
    private GridPane pane;
    private Scene scene;
    private MenuManager menuManager;
    public Menu(MenuManager menuManager)
    {
        this.menuManager = menuManager;
        pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        scene = new Scene(pane, screenWidth, screenHeight);
        initMenu();
    }
    
    public abstract void initMenu();
    
    public abstract void onMenuEntry();
    
    public abstract void onMenuExit();
    
    public Scene getScene()
    {
        return this.scene;
    }
    
    public GridPane getPane()
    {
        return this.pane;
    }
    
    public MenuManager getMenuManager()
    {
        return menuManager;
    }
}
