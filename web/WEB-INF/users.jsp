<%-- 
    Document   : users
    Created on : 26-Oct-2022, 3:49:03 PM
    Author     : mhamed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Users</title>
    </head>
    <body>
        <h1>Manage Users</h1>
        
        <c:choose>
            <c:when test="${users.count gt 0}">
                <table>
                    <tr>
                        <th><b>Email</b></th>
                        <th><b>First Name</b></th>
                        <th><b>Last Name</b></th>
                        <th><b>Password</b></th>
                        <th><b>Role</b></th>
                    </tr>
                    <c:forEach var="Variable" items="Variable">
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><a href="User?action=edit">Edit</a></td>
                            <td><a href="User?action=delete">Delete</a></td>
                        </tr>
                        
                    </c:forEach>
                    
                </table>
            </c:when>
            <c:when test="${users.count == 0}">
                <b>No Users found. Please add a user.</b>
            </c:when>
        </c:choose>
        
        <!-- display users table here-->

        <h2>Add Users</h2>
        <form action="User?action=add" method="post">
            Email: <input type="text" name="email"><br>            
            First name: <input type="text" name="Fname"><br>            
            Last Name: <input type="text" name="Lname"><br>
            Password: <input type="password" name="password"><br>
            Role: <select name="role"><br>
                <option value="admin">System Admin</option>
                <option value="regular">Regular User</option>
            </select> <br>
            
            <input type="submit" value="Add">
        </form>
        
    </body>
</html>
