
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Isaac Mhamed
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //display all users in table in users.jsp 
        
        
        
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
