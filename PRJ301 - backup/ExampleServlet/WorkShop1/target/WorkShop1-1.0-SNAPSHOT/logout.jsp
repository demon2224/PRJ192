<%-- 
    Document   : logout
    Created on : Feb 20, 2025, 1:39:24 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
//    session.removeAttribute("user"); chi xoa 1
    session.invalidate(); // xoa het session
    response.sendRedirect("login.jsp");
%>
