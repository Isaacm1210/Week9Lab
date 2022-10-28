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
        <c:if test="${user.size() lt 1}">
            <b>No users found. Please add a user.</b>
        </c:if>
        
        <c:if test="${user.size() gt 0}">
        <table border="1">
            <tr>
                <th>Email</th>
                <th>Fist Name</th>
                <th>last Name</th>
                <th>Role</th>
            </tr>
            <c:forEach var="user" items="${user}">            
            <tr>
                <td>${user.email}</td>
                <td>${user.firstname}</td>
                <td>${user.lastname}</td>
                <td>${user.role.roleName}</td>
                <td><a href="">Edit</a></td>
                <td><a href="">Delete</a></td>
            </tr>
        </c:forEach>
        </table>
        </c:if>
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
