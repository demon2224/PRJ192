<%@page import="model.Account"%>
<%@page import="model.TikTokAwards"%>
<%@page import="dao.TikTokAwardsDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Account acc = (Account) session.getAttribute("user");
    if (acc == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    TikTokAwardsDAO tikTokAwardsDAO = new TikTokAwardsDAO();
    String idString = request.getParameter("id");
    int id = 0;
    TikTokAwards tikTokAwards = null;
    String errorMessage = null;

    if (idString != null && !idString.isEmpty()) {
        try {
            id = Integer.parseInt(idString);
            tikTokAwards = tikTokAwardsDAO.getAccountById(id);
        } catch (NumberFormatException e) {
            errorMessage = "Invalid ID format.";
        }
    } else {
        errorMessage = "ID is required.";
    }

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String Name = request.getParameter("Name");
        String Account = request.getParameter("Account");
        String Category = request.getParameter("Category");
        String YearsRaw = request.getParameter("Years");

        if (Name != null && !Name.trim().isEmpty()
                && Account != null && !Account.trim().isEmpty()
                && Category != null && !Category.trim().isEmpty()
                && YearsRaw != null && !YearsRaw.trim().isEmpty()) {

            try {
                int Years = Integer.parseInt(YearsRaw);
                if (Years <= 2025) {
                    if (tikTokAwardsDAO.update(id, Name, Account, Category, Years) == 1) {
                        response.sendRedirect("awards.jsp");
                        return;
                    } else {
                        errorMessage = "Update failed. Please try again.";
                    }
                } else {
                    errorMessage = "Update failed: Year must not exceed 2025.";
                }
            } catch (NumberFormatException e) {
                errorMessage = "Invalid year format.";
            }
        } else {
            errorMessage = "All fields are required.";
        }
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Award</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Update Award</h1>

            <% if (errorMessage != null) {%>
            <div class="alert alert-danger"><%= errorMessage%></div>
            <% } %>

            <% if (tikTokAwards != null) {%>
            <form method="POST">
                <label class="form-label">ID</label>
                <input type="number" name="id" class="form-control" readonly value="<%= tikTokAwards.getId()%>">

                <label class="form-label">Name</label>
                <input type="text" name="Name" class="form-control" value="<%= tikTokAwards.getName()%>">

                <label class="form-label">Account</label>
                <input type="text" name="Account" class="form-control" value="<%= tikTokAwards.getAccount()%>">

                <label class="form-label">Category</label>
                <input type="text" name="Category" class="form-control" value="<%= tikTokAwards.getCategory()%>">

                <label class="form-label">Years</label>
                <input type="text" name="Years" class="form-control" value="<%= tikTokAwards.getYears()%>">

                <div class="col mt-3">
                    <a href="awards.jsp" class="btn btn-danger">Back</a>
                    <input type="submit" class="btn btn-primary" value="Update Award">
                </div>
            </form>
            <% } else { %>
            <p class="alert alert-warning">No award found with the given ID.</p>
            <a href="awards.jsp" class="btn btn-secondary">Back</a>
            <% }%>
        </div>
    </body>
</html>
