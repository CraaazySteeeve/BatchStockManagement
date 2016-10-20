package batchstockmanagement;

import java.util.ArrayList;

/**
 *
 * @author Joshua Coombes-Hall
 */
public class Login 
{
    ArrayList<SystemUser> users; //This will be replaced by a database.
    
    public Login()
    {
        users = new ArrayList<SystemUser>();
        boolean success = addUser("admin", "password", "Joshua", "Coombes-Hall", AdminUser.class);
    }
    
    public SystemUser verifyLogin(String username, String password)
    {
        for(int i = 0; i < users.size(); i++)
        {
            if(users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password))
            {
                return users.get(i);
            }
        }
        return null;
    }
    
    // The userType vairable expects you to pass through the type of the User the new user will be. (Eg BasicUser.class)
    public boolean addUser(String username, String password, String firstName, String lastName, Class<?> userType)
    {
        for(int i = 0; i < users.size(); i++)
        {
            if(users.get(i).getUsername().equals(username))
            {
                return false; //Can not have the same surname as another user.
            }
        }
        if(userType == AdminUser.class)
        {
            AdminUser newUser = new AdminUser(username, password, firstName, lastName);
            users.add(newUser);
            return true;
        }
        else if(userType == ManagerUser.class)
        {
            ManagerUser newUser = new ManagerUser(username, password, firstName, lastName);
            users.add(newUser);
            return true;
        }
        else if(userType == BasicUser.class)
        {
            BasicUser newUser = new BasicUser(username, password, firstName, lastName);
            users.add(newUser);
            return true;
        }
        else
        {
            return false;
        }
    }
}
