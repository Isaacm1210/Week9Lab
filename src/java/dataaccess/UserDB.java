
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Role;
import models.User;
import services.RoleService;

/**
 *
 * @author mhame
 */
public class UserDB {
    
    public List<User> getAll() throws Exception{
        
        List<User> users = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        RoleService rService = new RoleService();
        
        String sql = "SELECT * FROM USER";
        
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String email = rs.getString(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String password = rs.getString(4);
                Role role = rService.getRole(rs.getInt(5));
                User user = new User(email, firstName, lastName, password, role);
                
                users.add(user);
            } 
        }
        finally{
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return users;
    }
    
    public User getUser(String email) throws Exception{
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        User user = new User();
        RoleService rService = new RoleService();
        
        String sql = "SELECT * FROM user WHERE email=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while(rs.next()){
                String fistname = rs.getString(2);
                String lastname = rs.getString(3);
                String password = rs.getString(4);
                Role role = rService.getRole(rs.getInt(5));
                user = new User(email, fistname, lastname, password, role);
            }
            
        }
        finally{
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return user;
    }
    
    public void deleteUser(String email) throws Exception{
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "DELETE FROM user " 
                + "WHERE email = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.executeUpdate();
        }
        finally{
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
    
    public void updateUser()throws Exception{
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "UPDATE user SET" 
                + "email = ?" 
                + "first_name = ?" 
                + "last_name = ?"
                + "password = ?"
                + "role = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, sql);
            ps.setString(2, sql);
            ps.setString(3, sql);
            ps.setString(4, sql);
            ps.setInt(5, 0);
            ps.executeUpdate();
        }
        finally{
           DBUtil.closeResultSet(rs);
           DBUtil.closePreparedStatement(ps);
           cp.freeConnection(con); 
        }
        
        
    }
    
    public void addUser() throws Exception{
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "INSERT INTO user " 
                + "(email, firt_name, last_name, password, role) "
                + "VALUES " 
                + "(?, ?, ?, ?, ?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, sql);
            ps.setString(2, sql);
            ps.setString(3, sql);
            ps.setString(4, sql);
            ps.setInt(5, 1);
            ps.executeUpdate();
        }
        finally{
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
    }

}
