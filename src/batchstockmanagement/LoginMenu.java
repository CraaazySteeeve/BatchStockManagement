package batchstockmanagement;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
 * @author Joshua-Coombes-Hall
 */
public class LoginMenu extends Menu 
{
    private final Login loginChecker;
    private TextField usernameInput;
    private PasswordField passwordInput;
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
        Text heading = new Text("Login");
        getPane().add(heading, 0, 0, 2, 1);
        
        //Username
        Label usernameLabel = new Label("Username: ");
        getPane().add(usernameLabel, 0, 1);
        usernameInput = new TextField();
        getPane().add(usernameInput, 1, 1);
        
        //Password
        Label passwordLabel = new Label("Password: ");
        getPane().add(passwordLabel, 0, 2);
        passwordInput = new PasswordField();
        getPane().add(passwordInput, 1, 2);
        
        //Submit Button
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
                    loginFailure.setText("Please enter details.");
                }
            }
        });
        HBox btnBox = new HBox(10);
        btnBox.getChildren().add(loginSubmit);
        btnBox.setAlignment(Pos.CENTER_RIGHT);
        getPane().add(btnBox, 0, 3, 2, 1);
        
        //Allows Enter to submit the form.
        getPane().setOnKeyPressed(new EventHandler<KeyEvent>() 
        {
            @Override
            public void handle(KeyEvent keyEvent) 
            {
                if(keyEvent.getCode() == KeyCode.ENTER)
                {
                    loginSubmit.fire();
                }
            }
        });
        
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
        hideLogoutArea();
    }
    
    @Override
    public void onMenuExit()
    {
        showLogoutArea();
    }
    
}
