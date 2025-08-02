/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.CowDAO;
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
import model.Cows;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UpdateCowController", urlPatterns = {"/updateCow"})
public class UpdateCowController extends HttpServlet {

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
            out.println("<title>Servlet UpdateCowController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateCowController at " + request.getContextPath() + "</h1>");
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
        CowDAO productDAO = new CowDAO();
        String idRaw = request.getParameter("id");
        int id = 0;
        try {
            id = Integer.parseInt(idRaw);
            Cows product = productDAO.getAccountById(id);
            request.setAttribute("data", product);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.print(e.getMessage());
            System.out.println(e.getMessage());
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
        String action = request.getParameter("btnUpdate") != null ? "update"
                : (request.getParameter("btnReset") != null ? "back" : null);
        CowDAO productDAO = new CowDAO();
        String errorMessage = null;
        if (action.equalsIgnoreCase("update")) {
            String idRaw = request.getParameter("id");
            String name = request.getParameter("txtCowName");
            String breed = request.getParameter("txtCowBreed");
            String farm = request.getParameter("txtCowFarm");
            String age = request.getParameter("txtCowAge");
            String weight = request.getParameter("txtCowWeight");
            String milk = request.getParameter("txtCowMilk");
            String health = request.getParameter("txtCowStatus");

            try {
                int id = Integer.parseInt(idRaw);
                int a = Integer.parseInt(age);
                int w = Integer.parseInt(weight);
                int m = Integer.parseInt(milk);

                if (productDAO.update(new Cows(id, name, breed, farm, a, w, m, health)) == 1) {
                    response.sendRedirect("cows");
                } else {
                    errorMessage = "<div class=\"alert alert-danger\">Failed to update product. Please try again!</div>";
                    request.setAttribute("err", errorMessage);
                    request.getRequestDispatcher("update.jsp").forward(request, response);
                    PrintWriter out = response.getWriter();
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                PrintWriter out = response.getWriter();
                out.print(e.getMessage());
            }
        } else {
            response.sendRedirect("cows");
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
