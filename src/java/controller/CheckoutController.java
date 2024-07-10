/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountDAO;
import dao.OrderDAO;
import entity.Account;
import entity.Order;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Admin
 */
@WebServlet(name = "CheckoutController", urlPatterns = {"/checkout"})
public class CheckoutController extends HttpServlet {

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
        try {

            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("acc");
            if (acc != null) {
                String priceStr = request.getParameter("price");
                // get current Date
                Date date = new Date();
                // Convert Date to Calendar
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                Date exp = date;

                int price = 0;
                if (priceStr.equals("1")) {
                    price = 100000;

                    // Add 1 month
                    calendar.add(Calendar.MONTH, 1);
                    exp = calendar.getTime();
                } else if (priceStr.equals("2")) {
                    price = 500000;

                    // Add 6 months
                    calendar.add(Calendar.MONTH, 6);
                    exp = calendar.getTime();
                } else if (priceStr.equals("3")) {
                    price = 1000000;

                    // Add 1 year
                    calendar.add(Calendar.YEAR, 1);
                    exp = calendar.getTime();
                }
                OrderDAO orderDAO = new OrderDAO();
                Order order = new Order(date, exp, price, acc.getId());
                //insert order
                orderDAO.insertOrder(order);

                //register member
                AccountDAO accountDAO = new AccountDAO();
                acc.setIsMember(1);
                accountDAO.registerMember(acc);

                request.setAttribute("message", "Register success!");
                request.getRequestDispatcher("member-register.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.err.println("error");
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
