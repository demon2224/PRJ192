<%-- 
    Document   : addnew
    Created on : Feb 14, 2025, 11:47:53 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    </head>
    <body>
        <div class="container">
            <h1>Create New</h1>
            <p>Product</p>
            <form method="post">
                <div class="mb-3 row">
                    <label class="col-sm-2 col-form-label">Product ID</label>
                    <div class="col-sm-10">
                        <input type="Textbox" class="form-control" name="txtID">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label class="col-sm-2 col-form-label">Product Name</label>
                    <div class="col-sm-10">
                        <input type="Textbox" class="form-control" name="txtName">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label class="col-sm-2 col-form-label">Price</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" name="txtPrice">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label class="col-sm-2 col-form-label">Quantity</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" name="txtQuan">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label class="col-sm-2 col-form-label">Product ID</label>
                    <div class="col-sm-10">
                        <textarea class="form-control" name="txtDes" rows="3"></textarea>
                    </div>
                </div>
                <div class="mb-3 row">
                    <label class="col-sm-2 col-form-label">Category Name</label>
                    <div class="col-sm-10">
                        <select class="form-select" aria-label="Default select example" name="cboCat">
                            <option selected>Apple</option>
                            <option value="1">Sumsung</option>
                            <option value="2">Xiaomi</option>
                        </select>
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col-sm-10 offset-sm-2">
                        <button type="submit" name="btnCreate" class="btn btn-primary">Create</button>
                        <a href="index.jsp" class="btn btn-danger">Back to list</a>
                    </div>
                </div>
            </form>

        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

    </body>
</html>
