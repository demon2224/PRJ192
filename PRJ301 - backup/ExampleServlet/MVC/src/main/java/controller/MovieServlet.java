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
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Movies;
import model.Users;

/**
 *
 * @author Admin
 */
@WebServlet(name = "MovieServlet", urlPatterns = {"/Movie"})
public class MovieServlet extends HttpServlet {

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
        MoviesDAO moviesDAO = new MoviesDAO();
        if (action.equalsIgnoreCase("list")) {
            List<Movies> movieses = moviesDAO.getAll();
            request.setAttribute("list", movieses);
            request.getRequestDispatcher("movies.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("Create")) {
            response.sendRedirect("create-movie.jsp");
        } else if (action.equalsIgnoreCase("delete")) {
            String idRaw = request.getParameter("id");
            int id = 0;
            try {
                id = Integer.parseInt(idRaw);
                Movies movies = moviesDAO.getAccountById(id);
                request.setAttribute("data", movies);
                request.getRequestDispatcher("delete-movie.jsp").forward(request, response);
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
                Movies movies = moviesDAO.getAccountById(id);
                request.setAttribute("data", movies);
                request.getRequestDispatcher("edit-movie.jsp").forward(request, response);
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
        MoviesDAO moviesDAO = new MoviesDAO();
        String errorMessage = null;
        if (action.equalsIgnoreCase("Create")) {
            String title = request.getParameter("title");
            String director = request.getParameter("director");
            String release_yearRaw = request.getParameter("releaseYear");
            String ratingRaw = request.getParameter("rating");
            boolean Is_rented = request.getParameter("isRented") != null;
            try {
                int release_year = Integer.parseInt(release_yearRaw);
                double rating = Double.parseDouble(ratingRaw);
                if (moviesDAO.insert(new Movies(title, director, release_year, rating, Is_rented)) == 1) {
                    response.sendRedirect("Movie");
                } else {
                    errorMessage = "<div class=\"alert alert-danger\">Failed to insert movie. Please try again!</div>";
                    request.setAttribute("err", errorMessage);
                    request.getRequestDispatcher("create-movie.jsp").forward(request, response);
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
                if (moviesDAO.delete(id) == 1) {
                    response.sendRedirect("Movie");
                } else {
                    errorMessage = "<div class=\"alert alert-danger\">Failed to delete movie. Please try again!</div>";
                    request.setAttribute("err", errorMessage);
                    request.getRequestDispatcher("Movie?action=delete&id=" + id).forward(request, response);
                }
            } catch (Exception e) {
                PrintWriter out = response.getWriter();
                out.print(e.getMessage());
            }
        } else if (action.equalsIgnoreCase("update")) {
            String idRaw = request.getParameter("id");
            String title = request.getParameter("title");
            String director = request.getParameter("director");
            String release_yearRaw = request.getParameter("releaseYear");
            String ratingRaw = request.getParameter("rating");
            boolean Is_rented = request.getParameter("isRented") != null;

            try {
                int id = Integer.parseInt(idRaw);
                int release_year = Integer.parseInt(release_yearRaw);
                double rating = Double.parseDouble(ratingRaw);
                if (moviesDAO.update(new Movies(id, title, director, release_year, rating, Is_rented)) == 1) {
                    response.sendRedirect("Movie");
                } else {
                    errorMessage = "<div class=\"alert alert-danger\">Failed to edit movie. Please try again!</div>";
                    request.setAttribute("err", errorMessage);
                    request.getRequestDispatcher("Movie?action=update&id=" + id).forward(request, response);

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
