
package services;

import dataaccess.UserDB;
import java.util.ArrayList;
import java.util.List;
import models.Role;
import models.User;

/**
 *
 * @author mhame
 */
public class UserService {
    
    public List<User> getAll() throws Exception{
        UserDB userDB = new UserDB();
        List<User> user = userDB.getAll();
        return user;  
    }
    
    public User getUser(String email) throws Exception{
        UserDB userDB = new UserDB();
        User user = userDB.getUser(email);
        return user;
    }
    
    public void addUser(String email, String firstName, String lastName, String password, Role role) throws Exception{
        User user = new User(email, firstName, lastName, password);
        UserDB userDB = new UserDB();
        user.setRole(role);
        
        userDB.addUser(user);
    }
    
    public void updateUser(String email, String firstName, String lastName, String password, Role role) throws Exception{
        UserDB userDB = new UserDB();
        User user = userDB.getUser(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setRole(role);
        
        userDB.updateUser(user);
    }
    
    public void deleteUser(String email) throws Exception{
        UserDB userDB = new UserDB();
        User user = userDB.getUser(email);
        userDB.deleteUser(user);
    }
    
    public String userExist(String email) throws Exception{
        UserDB userDB = new UserDB();
        User user = userDB.getUser(email);
        
        if (user == null){
            return null;
        }
        else{
            return user.getEmail();
        } 
    }
}
