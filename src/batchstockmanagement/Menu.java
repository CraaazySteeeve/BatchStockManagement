package batchstockmanagement;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Screen;

/**
 *
 * @author Joshua Coombes-Hall
 */
public abstract class Menu 
{
    private double screenWidth = Screen.getPrimary().getVisualBounds().getWidth(), screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
    private String headingText = "Batch Stock Management";
    private BorderPane windowPane;
    private GridPane contentPane;
    private GridPane header;
    private Scene scene;
    private MenuManager menuManager;
    private Text userName;
    private Button logout;
    public Menu(MenuManager menuManager)
    {
        this.menuManager = menuManager;
        
        windowPane = new BorderPane();
        contentPane = new GridPane();
        contentPane.setAlignment(Pos.CENTER);
        contentPane.setHgap(10);
        contentPane.setVgap(10);
        windowPane.setCenter(contentPane);
        
        //Initalise the header bar.
        header = new GridPane();
        header.setPadding(new Insets(20,20,20,40));
        header.setStyle("-fx-background-color: #336699;");
        //Add the header.
        Text heading = new Text(headingText);
        header.add(heading, 0, 0);
        heading.setStyle("-fx-font-size: 20;");
        userName = new Text("J.Coombes-Hall");
        header.add(userName, 1, 0);
        logout = new Button("Logout");
        logout.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent e) 
            {
                menuManager.showMenu(menuManager.loginMenu);
            }
        });
        header.add(logout, 2, 0);
        
        ColumnConstraints titleCol = new ColumnConstraints();
        titleCol.setPercentWidth(70);
        ColumnConstraints nameCol = new ColumnConstraints();
        nameCol.setPercentWidth(15);
        ColumnConstraints logoutCol = new ColumnConstraints();
        logoutCol.setHalignment(HPos.RIGHT);
        logoutCol.setPercentWidth(15);
        
        header.getColumnConstraints().addAll(titleCol, nameCol, logoutCol);
        windowPane.setTop(header);
        scene = new Scene(windowPane, screenWidth, screenHeight);
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
        return this.contentPane;
    }
    
    public MenuManager getMenuManager()
    {
        return menuManager;
    }
    
    public void setUserName(String name)
    {
        userName.setText(name);
    }
    
    public void hideLogoutArea()
    {
        userName.setVisible(false);
        logout.setVisible(false);
    }
    
    public void showLogoutArea()
    {
        userName.setVisible(true);
        logout.setVisible(true);
    }
}
