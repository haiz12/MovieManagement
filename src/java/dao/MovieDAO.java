/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Category;
import entity.Movie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class MovieDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Movie> findAll() {
        List<Movie> list = new ArrayList<>();
        String sql = "select * from Movie";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Movie(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8)
                ));
            }
        } catch (Exception ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Movie> findTop6Newest() {
        List<Movie> list = new ArrayList<>();
        String sql = "select top 6 * from Movie order by id desc";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Movie(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8)
                ));
            }
        } catch (Exception ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Movie> findByCategoryId(int categoryId) {
        List<Movie> list = new ArrayList<>();
        String sql = "select * from Movie where categoryId = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, categoryId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Movie(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8)
                ));
            }
        } catch (Exception ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Movie> findByFilterAndPagination(String nameSearch, String categoryId, String sort, Integer pageIndex, Integer pageSize) {
        List<Movie> listMovie = new ArrayList<>();
        String sql = "select * from Movie ";
        if ((nameSearch != null && !nameSearch.trim().equals("")) && categoryId != null && !categoryId.trim().equals("")) {
            sql += "where name like ? and categoryId = ? ";
        } else if (nameSearch != null && !nameSearch.trim().equals("")) {
            sql += "where name like ? ";
        } else if (categoryId != null && !categoryId.trim().equals("")) {
            sql += "where categoryId = ? ";
        }

        if (pageIndex != null && pageSize != null) {
            if (sort != null && sort.equals("asc")) {
                sql += " ORDER BY name OFFSET\n"
                        + "                    (?*?-?) ROWS FETCH NEXT ? ROWS ONLY";
            } else if (sort != null && sort.equals("desc")) {
                sql += " ORDER BY name desc OFFSET\n"
                        + "                    (?*?-?) ROWS FETCH NEXT ? ROWS ONLY";
            }
        } else {
            if (sort != null && sort.equals("asc")) {
                sql += " ORDER BY name";
            } else if (sort != null && sort.equals("desc")) {
                sql += " ORDER BY name desc";
            }
        }

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            if ((nameSearch != null && !nameSearch.trim().equals("")) && categoryId != null && !categoryId.trim().equals("")) {
                ps.setString(1, "%" + nameSearch + "%");
                ps.setString(2, categoryId);
                if (pageIndex != null && pageSize != null) {
                    ps.setInt(3, pageIndex);
                    ps.setInt(4, pageSize);
                    ps.setInt(5, pageSize);
                    ps.setInt(6, pageSize);
                }
            } else if (nameSearch != null && !nameSearch.trim().equals("")) {
                ps.setString(1, "%" + nameSearch + "%");
                if (pageIndex != null && pageSize != null) {
                    ps.setInt(2, pageIndex);
                    ps.setInt(3, pageSize);
                    ps.setInt(4, pageSize);
                    ps.setInt(5, pageSize);
                }
            } else if (categoryId != null && !categoryId.trim().equals("")) {
                ps.setString(1, categoryId);
                if (pageIndex != null && pageSize != null) {
                    ps.setInt(2, pageIndex);
                    ps.setInt(3, pageSize);
                    ps.setInt(4, pageSize);
                    ps.setInt(5, pageSize);
                }
            } else {
                if (pageIndex != null && pageSize != null) {
                    ps.setInt(1, pageIndex);
                    ps.setInt(2, pageSize);
                    ps.setInt(3, pageSize);
                    ps.setInt(4, pageSize);
                }
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                listMovie.add(new Movie(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8)
                ));
            }
        } catch (Exception ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMovie;
    }

    public Movie getMovieById(int id) {
        String sql = "select * from Movie where id=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Movie(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8));
            }
        } catch (Exception ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void deleteMovie(int id) {
        String sql = "Delete from Movie where id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addNewMovie(Movie m) {
        String sql = "INSERT into Movie (name, [image], description, publishedDate, isFree, categoryId, movieLink)\n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, m.getName());
            ps.setString(2, m.getImage());
            ps.setString(3, m.getDescription());
            ps.setDate(4, new java.sql.Date(m.getPublishDate().getTime()));
            ps.setInt(5, m.getIsFree());
            ps.setInt(6, m.getCategoryId());
            ps.setString(7, m.getMovieLink());
            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateMovie(Movie m) {
        String sql = "UPDATE Movie set name = ?,  [image] = ?, description = ?, isFree = ?, categoryId = ?, movieLink = ? where id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, m.getName());
            ps.setString(2, m.getImage());
            ps.setString(3, m.getDescription());
            ps.setInt(4, m.getIsFree());
            ps.setInt(5, m.getCategoryId());
            ps.setString(6, m.getMovieLink());
            ps.setInt(7, m.getId());
            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
