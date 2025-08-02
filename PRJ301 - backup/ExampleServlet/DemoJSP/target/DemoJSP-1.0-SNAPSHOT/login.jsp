<%-- 
    Document   : login
    Created on : Jan 20, 2025, 5:18:17 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post">
            Enter username:
            <input type="text" name="username"
                   placeholder="the username" value="" required />
            <br/>
            Enter password:
            <input type="password" name="password"
                   placeholder="the password" value="" required/>
            <br/>
            <input type="submit" value="Login"/>
        </form>    
        <% 
            if (request.getAttribute("msg") != null) {
                String str = (String) request.getAttribute("msg");
                out.println(str);
            }
                
        %>
    </body>
</html>
