/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class OrderDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public boolean checkExpirationDate(int accId) {
        boolean isExpiration = false;
        List<Order> list = new ArrayList<>();
        String sql = "select * from [Order] where accountId = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, accId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1),
                        rs.getDate(2),
                        rs.getDate(3),
                        rs.getDouble(4),
                        rs.getInt(5)
                ));
            }
            Date currentDate = new Date();
            for (Order order : list) {
                Date expDate = order.getExpirationDate();
                if (currentDate.compareTo(expDate) <= 0) {
                    isExpiration = true;
                    break;
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isExpiration;
    }
    
    public void insertOrder(Order order) {
        String query = "INSERT INTO [Order](orderDate, expirationDate,price,accountId)\n"
                + "VALUES (?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setDate(1, new java.sql.Date(order.getOrderDate().getTime()));
            ps.setDate(2, new java.sql.Date(order.getExpirationDate().getTime()));
            ps.setDouble(3, order.getPrice());
            ps.setInt(4, order.getAccountId());
            ps.executeUpdate();
        } catch (Exception ex) {
             Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public double getTotalEarnings() {
        double total = 0;
        String query = "SELECT sum(price) from [Order]";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            rs = ps.executeQuery();//chay cau lenh query, nhan ket qua tra ve
            while (rs.next()) {
                total = rs.getDouble(1);
            }

        } catch (Exception e) {
        }
        return total;
    }
}
