
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Role;


import models.User;
import services.RoleService;
import services.UserService;
/**
 *
 * @author Isaac Mhamed
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        UserService us = new UserService();
        
        
        
        
        String action = (String)request.getParameter("action");
        String email = request.getParameter("Email");
        
        if(action != null && action.equals("edit")){
            try {
                User editUser = us.getUser(email);
                request.setAttribute("editUser", editUser);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            session.setAttribute("change", "edit");  
        }
        
        
        if(action != null && action.equals("delete")){
            
            try {
                us.deleteUser(email);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        try{
            List<User> user = us.getAll();
            session.setAttribute("user", user);
        }
        catch(Exception ex){
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        UserService us = new UserService();
        RoleService rs = new RoleService();
        
        String email = request.getParameter("email");
        String firstname = request.getParameter("Fname");
        String lastname = request.getParameter("Lname");
        String password = request.getParameter("password");
        int roleID = Integer.parseInt(request.getParameter("role"));
            
            
        //add user method
        if(action.equals("add")){
            
            if(password.equals("") || email.equals("") || firstname.equals("") || lastname.equals("")){
                request.setAttribute("message", "All fields are requried");
            }
            else{
                try {
                    Role role = rs.getRole(roleID);
                    us.addUser(email, firstname, lastname, password, role);
                } catch (Exception ex) {
                    Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        //update user method
        if(action.equals("Update")){
            
            session.setAttribute("change", "update");
            if(password.equals("") || email.equals("") || firstname.equals("") || lastname.equals("")){
                request.setAttribute("message", "All fields are requried");
            }
            else{
                try{
                    Role role = rs.getRole(roleID);
                    us.updateUser(email, firstname, lastname, password, role);
                }
                catch(Exception ex){
                    Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        //cancle update
        if(action.equals("Cancel")){
            session.setAttribute("change", "canceled");
        }

        try{
            List<User> user = us.getAll();
            request.setAttribute("user", user);
        }
        catch(Exception ex){
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

}
