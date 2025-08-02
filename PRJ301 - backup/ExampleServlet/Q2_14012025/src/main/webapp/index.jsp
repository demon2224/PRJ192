<%-- 
    Document   : index
    Created on : Jan 14, 2025, 5:15:54 PM
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
        <form action="sum" method="post
              ">
            Enter an integer array: <input type="text" name="array"/>
            <br/>
            Choose an option: 
            <input type="radio" name="option" value="odd"/> Odd
            <input type="radio" name="option" value="even"/> Even
            <br/>
            <input type="submit" value="SUM"/>
            
        </form>
    </body>
</html>
