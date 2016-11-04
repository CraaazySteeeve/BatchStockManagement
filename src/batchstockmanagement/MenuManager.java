package batchstockmanagement;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author Joshua Coombes-Hall
 */
public class MenuManager extends Application 
{
    //System tracking elements
    private Menu curMenu;
    SystemUser curUser;
    
    //GUI elements
    private Stage thestage;
    
    //Menus
    protected Menu loginMenu = new LoginMenu(this);
    protected Menu mainMenu = new MainMenu(this);
    
    
    @Override
    public void start(Stage primaryStage) 
    {
        thestage=primaryStage;
        primaryStage.setTitle("Batch and Stock Management");
        curMenu = loginMenu;
        curMenu.onMenuEntry();
        primaryStage.setScene(curMenu.getScene());
        primaryStage.show();
    }
    
    public void showMenu(Menu menuToSwitchTo)
    {
        curMenu.onMenuExit();
        thestage.setScene(menuToSwitchTo.getScene());
        curMenu = menuToSwitchTo;
        curMenu.onMenuEntry();
    }
    
    public void setCurrentUser(SystemUser newUser)
    {
        this.curUser = newUser;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
