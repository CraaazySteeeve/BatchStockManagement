package batchstockmanagement;

/**
 *
 * @author Joshua Coombes-Hall
 */
public abstract class SystemUser 
{
    private String username, password, firstName, lastName;
    
    public SystemUser(String username, String password, String firstName, String lastName)
    {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
}
