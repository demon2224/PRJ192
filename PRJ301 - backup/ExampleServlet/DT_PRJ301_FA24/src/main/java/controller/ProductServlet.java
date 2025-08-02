/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.CategoryDAO;
import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Category;
import model.Product;

/**
 *
 * @author Admin
 */
@WebServlet(name = "MovieServlet", urlPatterns = {"/Product"})
public class ProductServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MovieServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MovieServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        ProductDAO productDAO = new ProductDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        if (action.equalsIgnoreCase("list")) {
            List<Product> products = productDAO.getAll();
            request.setAttribute("list", products);
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else if (action.equalsIgnoreCase("create")) {
            List<Category> categorys = categoryDAO.getAll();
            request.setAttribute("list", categorys);
            request.getRequestDispatcher("addnew.jsp").forward(request, response);

        } else if (action.equalsIgnoreCase("delete")) {
            String id = request.getParameter("id");
            Product product = productDAO.getAccountById(id);
            List<Category> categorys = categoryDAO.getAll();
            request.setAttribute("data", product);
            request.setAttribute("list", categorys);
            request.getRequestDispatcher("delete.jsp").forward(request, response);

        } else if (action.equalsIgnoreCase("edit")) {
            String id = request.getParameter("id");
            Product product = productDAO.getAccountById(id);
            List<Category> categorys = categoryDAO.getAll();
            request.setAttribute("data", product);
            request.setAttribute("list", categorys);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        ProductDAO productDAO = new ProductDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        String errorMessage = null;
        if (action.equalsIgnoreCase("create")) {
            String proID = request.getParameter("txtID");
            String proName = request.getParameter("txtName");
            String proPriceRaw = request.getParameter("txtPrice");
            String proQuantityRaw = request.getParameter("txtQuan");
            String proDescription = request.getParameter("txtDes");
            String catId = request.getParameter("cboCat");
            try {
                long proPrice = Long.parseLong(proPriceRaw);
                int proQuantity = Integer.parseInt(proQuantityRaw);
                if (productDAO.insert(new Product(proID, proName, proPrice, proQuantity, proDescription, new Category(catId))) == 1) {
                    response.sendRedirect("Product");
                } else {
                    errorMessage = "<div class=\"alert alert-danger\">Failed to insert product. Please try again!</div>";
                    request.setAttribute("err", errorMessage);
                    List<Category> categorys = categoryDAO.getAll();
                    request.setAttribute("list", categorys);
                    request.getRequestDispatcher("addnew.jsp").forward(request, response);
                }
            } catch (Exception e) {
                PrintWriter out = response.getWriter();
                out.print(e.getMessage());
            }
        } else if (action.equalsIgnoreCase("delete")) {
            String id = request.getParameter("txtProID");
            if (productDAO.delete(id) == 1) {
                response.sendRedirect("Product");
            } else {
                errorMessage = "<div class=\"alert alert-danger\">Failed to delete movie. Please try again!</div>";
                request.setAttribute("err", errorMessage);
                request.getRequestDispatcher("Product?action=delete&id=" + id).forward(request, response);
            }

        } else if (action.equalsIgnoreCase("edit")) {
            String proID = request.getParameter("id");
            String proName = request.getParameter("txtName");
            String proPriceRaw = request.getParameter("txtPrice");
            String proQuantityRaw = request.getParameter("txtQuan");
            String proDescription = request.getParameter("txtDes");
            String catId = request.getParameter("cboCat");
            try {
                long proPrice = Long.parseLong(proPriceRaw);
                int proQuantity = Integer.parseInt(proQuantityRaw);
                if (productDAO.update(new Product(proID, proName, proPrice, proQuantity, proDescription, new Category(catId))) == 1) {
                    response.sendRedirect("Product");
                } else {
                    errorMessage = "<div class=\"alert alert-danger\">Failed to update product. Please try again!</div>";
                    request.setAttribute("err", errorMessage);
                    request.getRequestDispatcher("edit.jsp").forward(request, response);
                    PrintWriter out = response.getWriter();
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                PrintWriter out = response.getWriter();
                out.print(e.getMessage());
            }
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
