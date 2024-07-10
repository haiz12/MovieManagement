/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.CategoryDAO;
import dao.MovieDAO;
import entity.Category;
import entity.Movie;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Admin
 */
@WebServlet(name = "MovieListController", urlPatterns = {"/movie-list"})
public class MovieListController extends HttpServlet {

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
        int numberProductInPage = 6;

        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> lstCategory = categoryDAO.findAll();
        request.setAttribute("lstCategory", lstCategory);

        String categoryId = request.getParameter("categoryId");
        String txtSearch = request.getParameter("txtSearch");
        String sort = request.getParameter("sort");
        sort = (sort == null || sort.equals("")) ? "asc" : sort;

        String index = request.getParameter("pageIndex");

        // pagining
        MovieDAO movieDAO = new MovieDAO();
        List<Movie> allMovie = movieDAO.findByFilterAndPagination(txtSearch, categoryId, sort, null, null);
        int numberOfProduct = allMovie.size();
        int pageSize = getPageSize(numberProductInPage, numberOfProduct);

        int pageIndex = 0;
        if (index == null) {
            pageIndex = 1;
        } else {
            pageIndex = Integer.parseInt(index);
        }

        List<Movie> lstMovie = movieDAO.findByFilterAndPagination(txtSearch, categoryId, sort, pageIndex, numberProductInPage);

        Category c = null;
        if (categoryId != null) {
            for (Category category : lstCategory) {
                if ((category.getId() + "").equals(categoryId)) {
                    c = category;
                    break;
                }
            }
        }
        request.setAttribute("category", c);

        request.setAttribute("txtSearch", txtSearch);
        request.setAttribute("sort", sort);
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("totalPage", pageSize);
        request.setAttribute("lstMovie", lstMovie);
        request.getRequestDispatcher("movie-list.jsp").forward(request, response);
    }

    public int getPageSize(int numberProduct, int allProduct) {
        int pageSize = allProduct / numberProduct;
        if (allProduct % numberProduct != 0) {
            pageSize = (allProduct / numberProduct) + 1;
        }
        return pageSize;
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
        processRequest(request, response);
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
