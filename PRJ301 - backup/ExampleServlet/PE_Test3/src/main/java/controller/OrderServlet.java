/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import model.Order;

/**
 *
 * @author Admin
 */
@WebServlet(name = "MovieServlet", urlPatterns = {"/Order"})
public class OrderServlet extends HttpServlet {

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
        Cookie[] cookies = request.getCookies();
        String users = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equalsIgnoreCase("username")) {
                    users = cookie.getValue();
                }
            }
        }
        if (users == null) {
            response.sendRedirect("Login");
            return;
        }
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        OrderDAO productDAO = new OrderDAO();
        if (action.equalsIgnoreCase("list")) {
            List<Order> products = productDAO.getAll();
            request.setAttribute("list", products);
            request.getRequestDispatcher("order.jsp").forward(request, response);

        } else if (action.equalsIgnoreCase("create")) {
            request.getRequestDispatcher("addOrder.jsp").forward(request, response);
//        } else if (action.equalsIgnoreCase("delete")) {
//            String idRaw = request.getParameter("id");
//            int id = 0;
//            try {
//                id = Integer.parseInt(idRaw);
//                Order product = productDAO.getAccountById(id);
//                List<Category> categorys = categoryDAO.getAll();
//                request.setAttribute("data", product);
//                request.setAttribute("list", categorys);
//                request.getRequestDispatcher("delete-product.jsp").forward(request, response);
//            } catch (Exception e) {
//                PrintWriter out = response.getWriter();
//                out.print(e.getMessage());
//                System.out.println(e.getMessage());
//            }
//
        } else if (action.equalsIgnoreCase("update")) {
            String id = request.getParameter("id");
            Order product = productDAO.getAccountById(id);
            request.setAttribute("data", product);

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
        OrderDAO productDAO = new OrderDAO();
        String errorMessage = null;
        if (action.equalsIgnoreCase("create")) {
            String id = request.getParameter("txtOrID");
            String username = request.getParameter("txtOrName");
            String totalRaw = request.getParameter("txtOrTotal");
            String dateRaw = request.getParameter("txtOrDate");
            String des = request.getParameter("txtDescription");
            try {
                int total = Integer.parseInt(totalRaw);
                java.sql.Date date = java.sql.Date.valueOf(dateRaw);
                if (productDAO.insert(new Order(id, username, total, date, des)) == 1) {
                    response.sendRedirect("Order");
                } else {
                    errorMessage = "<div class=\"alert alert-danger\">Failed to insert product. Please try again!</div>";
                    request.setAttribute("err", errorMessage);
                    request.getRequestDispatcher("order.jsp").forward(request, response);
                }
            } catch (Exception e) {
                PrintWriter out = response.getWriter();
                out.print(e.getMessage());
            }
        } else if (action.equalsIgnoreCase("delete")) {
            String id = request.getParameter("id");

            if (productDAO.delete(id) == 1) {
                response.sendRedirect("Order");
            } else {
                errorMessage = "<div class=\"alert alert-danger\">Failed to delete movie. Please try again!</div>";
                request.setAttribute("err", errorMessage);
                request.getRequestDispatcher("Order?action=delete&id=" + id).forward(request, response);
            }

        } else if (action.equalsIgnoreCase("update")) {
            String id = request.getParameter("id");
            String username = request.getParameter("txtOrName");
            String totalRaw = request.getParameter("txtOrTotal");
            String dateRaw = request.getParameter("txtOrDate");
            String des = request.getParameter("txtDescription");
            try {
                int total = Integer.parseInt(totalRaw);
                java.sql.Date date = java.sql.Date.valueOf(dateRaw);
                if (productDAO.update(new Order(id, username, total, date, des)) == 1) {
                    response.sendRedirect("Order");
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
