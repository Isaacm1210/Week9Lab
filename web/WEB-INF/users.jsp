<%-- 
    Document   : users
    Created on : 26-Oct-2022, 3:49:03 PM
    Author     : mhamed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Users</title>
    </head>
    <body>
        <h1>Manage Users</h1>
        
        <!-- display users table here-->
        
        <h2>Add Users</h2>
        <form action="action" method="">
            Email: <input type="text" name="email"><br>
            First name: <input type="text" name="Fname"><br>
            Last Name: <input type="text" name="Lname"><br>
            Password: <input type="password" name="password"><br>
            Role: <select name="role"><br>
                <option value="admin">System Admin</option>
                <option value="regular">Regular User</option>
            </select> <br>
            <input type="submit" name="Add" value="Add">
        </form>
        
    </body>
</html>
