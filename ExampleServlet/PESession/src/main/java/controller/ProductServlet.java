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
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Category;
import model.Product;
import model.Users;

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
        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute("user");
        if (users == null) {
            response.sendRedirect("Login");
            return;
        }
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        ProductDAO productDAO = new ProductDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        if (action.equalsIgnoreCase("list")) {
            List<Product> products = productDAO.getAll();
            request.setAttribute("list", products);
            request.getRequestDispatcher("product.jsp").forward(request, response);

        } else if (action.equalsIgnoreCase("create")) {
            List<Category> categorys = categoryDAO.getAll();
            request.setAttribute("list", categorys);
            request.getRequestDispatcher("create-product.jsp").forward(request, response);

        } else if (action.equalsIgnoreCase("delete")) {
            String idRaw = request.getParameter("id");
            int id = 0;
            try {
                id = Integer.parseInt(idRaw);
                Product product = productDAO.getAccountById(id);
                List<Category> categorys = categoryDAO.getAll();
                request.setAttribute("data", product);
                request.setAttribute("list", categorys);
                request.getRequestDispatcher("delete-product.jsp").forward(request, response);
            } catch (Exception e) {
                PrintWriter out = response.getWriter();
                out.print(e.getMessage());
                System.out.println(e.getMessage());
            }

        } else if (action.equalsIgnoreCase("update")) {
            String idRaw = request.getParameter("id");
            int id = 0;
            try {
                id = Integer.parseInt(idRaw);
                Product product = productDAO.getAccountById(id);
                List<Category> categorys = categoryDAO.getAll();
                request.setAttribute("data", product);
                request.setAttribute("list", categorys);
                request.getRequestDispatcher("edit-product.jsp").forward(request, response);
            } catch (Exception e) {
                PrintWriter out = response.getWriter();
                out.print(e.getMessage());
                System.out.println(e.getMessage());
            }
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
        String errorMessage = null;
        if (action.equalsIgnoreCase("create")) {
            String proName = request.getParameter("pName");
            String proPriceRaw = request.getParameter("pPrice");
            String proQuantityRaw = request.getParameter("pQuantity");
            String proDescription = request.getParameter("pDescription");
            String catIdRaw = request.getParameter("cId");
            try {
                long proPrice = Long.parseLong(proPriceRaw);
                int proQuantity = Integer.parseInt(proQuantityRaw);
                int catID = Integer.parseInt(catIdRaw);
                if (productDAO.insert(new Product(proQuantity, proName, proPrice, proQuantity, proDescription, new Category(catID))) == 1) {
                    response.sendRedirect("Product");
                } else {
                    errorMessage = "<div class=\"alert alert-danger\">Failed to insert product. Please try again!</div>";
                    request.setAttribute("err", errorMessage);
                    request.getRequestDispatcher("create-product.jsp").forward(request, response);
                }
            } catch (Exception e) {
                PrintWriter out = response.getWriter();
                out.print(e.getMessage());
            }
        } else if (action.equalsIgnoreCase("delete")) {
            String idRaw = request.getParameter("id");
            int id = 0;
            try {
                id = Integer.parseInt(idRaw);
                if (productDAO.delete(id) == 1) {
                    response.sendRedirect("Product");
                } else {
                    errorMessage = "<div class=\"alert alert-danger\">Failed to delete movie. Please try again!</div>";
                    request.setAttribute("err", errorMessage);
                    request.getRequestDispatcher("Product?action=delete&id=" + id).forward(request, response);
                }
            } catch (Exception e) {
                PrintWriter out = response.getWriter();
                out.print(e.getMessage());
            }
        } else if (action.equalsIgnoreCase("update")) {
            String idRaw = request.getParameter("id");
            String proName = request.getParameter("pName");
            String proPriceRaw = request.getParameter("pPrice");
            String proQuantityRaw = request.getParameter("pQuantity");
            String proDescription = request.getParameter("pDescription");
            String catIdRaw = request.getParameter("cId");
            try {
                int id = Integer.parseInt(idRaw);
                long proPrice = Long.parseLong(proPriceRaw);
                int proQuantity = Integer.parseInt(proQuantityRaw);
                int catID = Integer.parseInt(catIdRaw);
                if (productDAO.update(new Product(id, proName, proPrice, proQuantity, proDescription, new Category(catID))) == 1) {
                    response.sendRedirect("Product");
                } else {
                    errorMessage = "<div class=\"alert alert-danger\">Failed to update product. Please try again!</div>";
                    request.setAttribute("err", errorMessage);
                    request.getRequestDispatcher("edit-product.jsp").forward(request, response);
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
