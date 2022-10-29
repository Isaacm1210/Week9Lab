
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
        
        try{
            List<User> user = us.getAll();
            session.setAttribute("user", user);
        }
        catch(Exception ex){
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String action = (String)request.getParameter("action");
        String Email = (String)request.getParameter("Email");
        
        if(action != null && action.equals("edit")){
            try {
                request.setAttribute("Email", Email);
                User editUser = us.getUser(Email);
                request.setAttribute("editUser", editUser);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            session.setAttribute("change", "edit");  
        }
        
        if(action != null && action.equals("delete")){
            request.setAttribute("message", "Delete test");
            request.setAttribute("Email", Email);
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
        
        //add user method
        if(action.equals("add")){
            String email = request.getParameter("email");
            String firstname = request.getParameter("Fname");
            String lastname = request.getParameter("Lname");
            String password = request.getParameter("password");
            int roleID = Integer.parseInt(request.getParameter("role"));
            request.setAttribute("message", roleID);
            try {
                Role role = rs.getRole(roleID);
                us.addUser(email, firstname, lastname, password, role);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //update user method
        if(action.equals("Update")){
            session.setAttribute("change", "update");
            String email = request.getParameter("email");
            String firstname = request.getParameter("Fname");
            String lastname = request.getParameter("Lname");
            String password = request.getParameter("password");
            int roleID = Integer.parseInt(request.getParameter("role"));
            
            try{
                Role role = rs.getRole(roleID);
                us.updateUser(email, firstname, lastname, password, role);
            }
            catch(Exception ex){
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("message", email + " test");
        }
        
        //cancle update
        if(action.equals("Cancel")){
            session.setAttribute("change", "canceled");
        }
        
        //delete user method  
        
        
        
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
