<%-- 
    Document   : create
    Created on : Feb 8, 2025, 2:47:25 PM
    Author     : Admin
--%>
<%@page import="dao.AccountDAO"%>
<%
    AccountDAO dao = new AccountDAO();
   
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    </head>
    <body>
        <div class="container">
            <h1>Create Account</h1>
            <a href="list.jsp" class="btn btn-primary">Back</a>
            <form method="POST">
                Username:
                <input type="text" name="username" required=""/> <br/>
                Password:
                <input type="text" name="password" required=""/> <br/>
                Fullname:
                <input type="text" name="fullname" required=""/> <br/>
                <input class="btn btn-info" type="submit" value="ADD"/>
            </form>
        </div>


        <% 
            if(request.getMethod().equals("POST")) {
                String username = request.getParameter("username");;
                String password = request.getParameter("password");;
                String fullname = request.getParameter("fullname");;
                if(!username.isEmpty() && !password.isEmpty() && !fullname.isEmpty()){
                    int num = dao.insert(username, password, fullname);
                    if (num == 1) {
                        response.sendRedirect("list.jsp");
                    } else {
                        out.println("<p>Create failed</p>");
                    }
                }
            }
        
        %>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

    </body>
</html>
