
package services;

import dataaccess.UserDB;
import java.util.ArrayList;
import models.User;

/**
 *
 * @author mhame
 */
public class UserService {
    
    public ArrayList<User> getAll() throws Exception{
        UserDB userDB = new UserDB();
        ArrayList<User> user = userDB.getAll();
        return user;  
    }
}
