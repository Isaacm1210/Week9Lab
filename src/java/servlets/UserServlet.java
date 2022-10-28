
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


import models.User;
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
        
        //display all users in table in users.jsp 
        
        UserService us = new UserService();
        
        try{
            List<User> user = us.getAll();
            request.setAttribute("user", user);
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
        

        //add user method
        if(action.equals("add")){
            String email = request.getParameter("email");
            String firstname = request.getParameter("Fname");
            String lastname = request.getParameter("Lname");
            String password = request.getParameter("password");
            String role = request.getParameter("role");
        }
        
        //edit user method
        
        
        //delete user method  
    }

}
