/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Movie {

    private int id;
    private String name;
    private String image;
    private String description;
    private Date publishDate;
    private int isFree;
    private int categoryId;
    private String movieLink;

    public Movie() {
    }

    public Movie(int id, String name, String image, String description, Date publishDate, int isFree, int categoryId, String movieLink) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.publishDate = publishDate;
        this.isFree = isFree;
        this.categoryId = categoryId;
        this.movieLink = movieLink;
    }
    
    public Movie(int id, String name, String image, String description, int isFree, int categoryId, String movieLink) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.isFree = isFree;
        this.categoryId = categoryId;
        this.movieLink = movieLink;
    }

    public Movie(String name, String image, String description, Date publishDate, int isFree, int categoryId, String movieLink) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.publishDate = publishDate;
        this.isFree = isFree;
        this.categoryId = categoryId;
        this.movieLink = movieLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public int getIsFree() {
        return isFree;
    }

    public void setIsFree(int isFree) {
        this.isFree = isFree;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getMovieLink() {
        return movieLink;
    }

    public void setMovieLink(String movieLink) {
        this.movieLink = movieLink;
    }

}
