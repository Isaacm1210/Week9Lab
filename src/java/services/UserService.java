
package services;

import dataaccess.UserDB;
import java.util.ArrayList;
import java.util.List;
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
}
