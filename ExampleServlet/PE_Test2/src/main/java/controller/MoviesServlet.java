/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.MoviesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Movies;

/**
 *
 * @author Admin
 */
@WebServlet(name = "MovieServlet", urlPatterns = {"/Movies"})
public class MoviesServlet extends HttpServlet {

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
        MoviesDAO productDAO = new MoviesDAO();
        if (action.equalsIgnoreCase("list")) {
            List<Movies> products = productDAO.getAll();
            request.setAttribute("list", products);
            request.getRequestDispatcher("movies.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("create")) {
            request.getRequestDispatcher("create.jsp").forward(request, response);

//        } else if (action.equalsIgnoreCase("delete")) {
//            String idRaw = request.getParameter("id");
//            int id = 0;
//            try {
//                id = Integer.parseInt(idRaw);
//                Movies product = productDAO.getAccountById(id);
//                request.setAttribute("data", product);
//                request.getRequestDispatcher("delete.jsp").forward(request, response);
//            } catch (Exception e) {
//                PrintWriter out = response.getWriter();
//                out.print(e.getMessage());
//                System.out.println(e.getMessage());
//            }
        } else if (action.equalsIgnoreCase("update")) {
            String idRaw = request.getParameter("id");
            int id = 0;
            try {
                id = Integer.parseInt(idRaw);
                Movies product = productDAO.getAccountById(id);
                request.setAttribute("data", product);
                request.getRequestDispatcher("edit.jsp").forward(request, response);
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
        MoviesDAO productDAO = new MoviesDAO();
        String errorMessage = null;
        if (action.equalsIgnoreCase("create")) {
            String title = request.getParameter("title");
            String director = request.getParameter("director");
            String yearRaw = request.getParameter("year");
            String ratingRaw = request.getParameter("rating");
            String rentRaw = request.getParameter("rented");
            try {
                int year = Integer.parseInt(yearRaw);
                Double rating = Double.parseDouble(ratingRaw);
                Boolean rent = Boolean.parseBoolean(rentRaw);
                if (productDAO.insert(new Movies(title, director, year, rating, rent)) == 1) {
                    response.sendRedirect("Movies");
                } else {
                    errorMessage = "<div class=\"alert alert-danger\">Failed to insert product. Please try again!</div>";
                    request.setAttribute("err", errorMessage);
                    request.getRequestDispatcher("create.jsp").forward(request, response);
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
                    response.sendRedirect("Movies");
                } else {
                    errorMessage = "<div class=\"alert alert-danger\">Failed to delete movie. Please try again!</div>";
                    request.setAttribute("err", errorMessage);
                    request.getRequestDispatcher("Movies?action=delete&id=" + id).forward(request, response);
                }
            } catch (Exception e) {
                PrintWriter out = response.getWriter();
                out.print(e.getMessage());
            }
        } else if (action.equalsIgnoreCase("update")) {
            String idRaw = request.getParameter("id");
            String title = request.getParameter("title");
            String director = request.getParameter("director");
            String yearRaw = request.getParameter("year");
            String ratingRaw = request.getParameter("rating");
            String rentRaw = request.getParameter("rented");
            try {
                int id = Integer.parseInt(idRaw);
                int year = Integer.parseInt(yearRaw);
                Double rating = Double.parseDouble(ratingRaw);
                Boolean rent = Boolean.parseBoolean(rentRaw);
                if (productDAO.update(new Movies(id, title, director, year, rating, rent)) == 1)  {
                    response.sendRedirect("Movies");
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
