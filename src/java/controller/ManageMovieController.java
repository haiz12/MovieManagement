/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountDAO;
import dao.CategoryDAO;
import dao.MovieDAO;
import dao.OrderDAO;
import entity.Category;
import entity.Movie;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ManageMovieController", urlPatterns = {"/manage-movie"})
public class ManageMovieController extends HttpServlet {

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
        MovieDAO movieDAO = new MovieDAO();
        CategoryDAO categoryDAO = new CategoryDAO();

        String movieId = request.getParameter("id");
        String message = (String) request.getAttribute("message");

        String action = request.getParameter("action");
        if (action != null && action.equals("delete")) {
            //delete
            movieDAO.deleteMovie(Integer.parseInt(movieId));
            message = "Delete successfull!";
        } else {
            //show product detail
            Boolean showEditDialog = (Boolean) request.getAttribute("showEditDialog");
            if (movieId != null && showEditDialog == null) {
                request.setAttribute("showEditDialog", true);
                Movie p = movieDAO.getMovieById(Integer.parseInt(movieId));
                request.setAttribute("movieDetail", p);
            }
        }

        request.setAttribute("message", message);

        List<Movie> lstMovie = movieDAO.findAll();
        request.setAttribute("lstMovie", lstMovie);
        List<Category> listCategory = categoryDAO.findAll();
        request.setAttribute("listCategory", listCategory);

        int numberOfMovie = lstMovie.size();
        AccountDAO accountDAO = new AccountDAO();
        int numberOfMember = accountDAO.getNumberOfMember();
        OrderDAO orderDAO = new OrderDAO();
        double totalEarnings = orderDAO.getTotalEarnings();
        request.setAttribute("numberOfMovie", numberOfMovie);
        request.setAttribute("numberOfMember", numberOfMember);
        request.setAttribute("totalEarnings", totalEarnings);

        request.getRequestDispatcher("manage-movie.jsp").include(request, response);
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
        processRequest(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        MovieDAO movieDAO = new MovieDAO();
        String action = request.getParameter("action");

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String description = request.getParameter("description");
        String isFree = request.getParameter("isFree");
        String categoryId = request.getParameter("category");
        String movieLink = request.getParameter("movieLink");
        switch (action) {
            case "Add":
                Date currentDate = new Date();
                Movie mAdd = new Movie(name, image, description, currentDate, Integer.parseInt(isFree), Integer.parseInt(categoryId), movieLink);
                movieDAO.addNewMovie(mAdd);
                request.setAttribute("message", "Create successfull!");
                processRequest(request, response);
                break;
            case "Save":
                Movie mEdit = new Movie(Integer.parseInt(id), name, image, description, Integer.parseInt(isFree), Integer.parseInt(categoryId), movieLink);
                movieDAO.updateMovie(mEdit);
                request.setAttribute("message", "Update successfull!");
                request.setAttribute("showEditDialog", false);
                processRequest(request, response);
                break;
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
