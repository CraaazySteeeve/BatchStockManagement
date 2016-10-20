package batchstockmanagement;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
 * @author Joshua-Coombes-Hall
 */
public class LoginMenu extends Menu 
{
    private Login loginChecker;
    private TextField usernameInput;
    private TextField passwordInput;
    private Button loginSubmit;
    private Text loginFailure;
    
    public LoginMenu(MenuManager menuManager)
    {
        super(menuManager);
        loginChecker = new Login();
    }
    
    @Override
    public void initMenu()
    {
        Text heading = new Text("Login Menu");
        getPane().add(heading, 0, 0, 2, 1);
        
        //Username
        Label usernameLabel = new Label("Username: ");
        getPane().add(usernameLabel, 0, 1);
        usernameInput = new TextField();
        getPane().add(usernameInput, 1, 1);
        
        //Password
        Label passwordLabel = new Label("Password: ");
        getPane().add(passwordLabel, 0, 2);
        passwordInput = new TextField();
        getPane().add(passwordInput, 1, 2);
        
        //Submit Box
        loginSubmit = new Button("Login");
        loginSubmit.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent e) 
            {
                if(usernameInput.getText().length() > 0 && passwordInput.getText().length() > 0)
                {
                    SystemUser loggedInUser = loginChecker.verifyLogin(usernameInput.getText(), passwordInput.getText());
                    if(loggedInUser != null)
                    {
                        getMenuManager().setCurrentUser(loggedInUser);
                        getMenuManager().showMenu(getMenuManager().mainMenu);
                    }
                    else
                    {
                        //No user found.
                        loginFailure.setFill(Color.FIREBRICK);
                        loginFailure.setText("Incorrect details.");
                    }
                }
                else
                {
                    //No input entered.
                    loginFailure.setFill(Color.FIREBRICK);
                    loginFailure.setText("Please fill in username and password.");
                }
                
                
            }
        });
        HBox btnBox = new HBox(10);
        btnBox.getChildren().add(loginSubmit);
        btnBox.setAlignment(Pos.CENTER_RIGHT);
        getPane().add(btnBox, 0, 3, 2, 1);
        
        //Login Falure Text.
        loginFailure = new Text();
        getPane().add(loginFailure, 1, 4);
    }
    
    @Override
    public void onMenuEntry()
    {
        usernameInput.setText("");
        passwordInput.setText("");
        loginFailure.setText("");
    }
    
    @Override
    public void onMenuExit()
    {
        
    }
}
