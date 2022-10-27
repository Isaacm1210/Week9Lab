
package models;

import java.io.Serializable;
/**
 *
 * @author mhame
 */
public class Role implements Serializable{
    String roleID;
    String roleName;
    
    public String getRoleID(){
        return roleID;
    }
    
    public void setRoleID(String roleID){
        this.roleID = roleID;
    }
    
    public String getRoleName(){
        return roleName;
    }
    
    public void setRoleName(String roleName){
        this.roleName = roleName;
    }
}
