/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

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
import model.Account;
import model.Product;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/list"})
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
            out.println("<title>Servlet ProductServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductServlet at " + request.getContextPath() + "</h1>");
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
        Account users = (Account) session.getAttribute("user");
        if (users == null) {
            response.sendRedirect("login");
            return;
        }
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        ProductDAO moviesDAO = new ProductDAO();
        if (action.equalsIgnoreCase("list")) {
            List<Product> movieses = moviesDAO.getAll();
            request.setAttribute("list", movieses);
            request.getRequestDispatcher("listProduct.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("create")) {
            response.sendRedirect("addProduct.jsp");

        } else if (action.equalsIgnoreCase("delete")) {
            String id = request.getParameter("id");
            Product movies = moviesDAO.getAccountById(id);
            request.setAttribute("data", movies);
            request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("update")) {
            String id = request.getParameter("id");
            Product movies = moviesDAO.getAccountById(id);
            request.setAttribute("data", movies);
            request.getRequestDispatcher("updateProduct.jsp").forward(request, response);

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
        ProductDAO moviesDAO = new ProductDAO();
        String errorMessage = null;
        if (action.equalsIgnoreCase("Create")) {
            String id = request.getParameter("txtProID");
            String name = request.getParameter("txtProName");
            String quantityRaw = request.getParameter("txtProQuantity");
            String priceRaw = request.getParameter("txtProPrice");
            String description = request.getParameter("txtProDescription");

            try {
                int quantity = Integer.parseInt(quantityRaw);
                long price = Long.parseLong(priceRaw);

                if (moviesDAO.insert(new Product(id, name, quantity, price, id)) == 1) {
                    response.sendRedirect("list");
                } else {
                    errorMessage = "<div class=\"alert alert-danger\">Failed to insert movie. Please try again!</div>";
                    request.setAttribute("err", errorMessage);
                    request.getRequestDispatcher("addProduct.jsp").forward(request, response);
                }
            } catch (Exception e) {
                PrintWriter out = response.getWriter();
                out.print(e.getMessage());
            }
        } else if (action.equalsIgnoreCase("delete")) {
            String id = request.getParameter("id");
            if (moviesDAO.delete(id) == 1) {
                response.sendRedirect("list");
            } else {
                errorMessage = "<div class=\"alert alert-danger\">Failed to delete movie. Please try again!</div>";
                request.setAttribute("err", errorMessage);
                request.getRequestDispatcher("Movie?action=delete&id=" + id).forward(request, response);
            }
        } else if (action.equalsIgnoreCase("update")) {
            String id = request.getParameter("id");
            String name = request.getParameter("txtProName");
            String quantityRaw = request.getParameter("txtProQuantity");
            String priceRaw = request.getParameter("txtProPrice");
            String description = request.getParameter("txtProDescription");
            try {
                int quantity = Integer.parseInt(quantityRaw);
                long price = Long.parseLong(priceRaw);
                if (moviesDAO.update(new Product(id, name, quantity, price, description)) == 1) {
                    response.sendRedirect("list");
                } else {
                    errorMessage = "<div class=\"alert alert-danger\">Failed to edit movie. Please try again!</div>";
                    request.setAttribute("err", errorMessage);
                    request.getRequestDispatcher("list?action=update&id=" + id).forward(request, response);

                }
            } catch (Exception e) {
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
