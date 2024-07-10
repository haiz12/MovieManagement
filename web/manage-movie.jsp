
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Manage Movie</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 150px;
                height: auto;
            }
            .thong-ke{
                border: 1px solid black;
                border-radius: 10px;
                text-align: center;
            }
        </style>
    <body>
        <div class="page-wrapper">
            <!-- MAIN CONTENT-->
            <div class="main-content">
                <div class="section__content section__content--p30">
                    <div class="container">
                        <div class="row m-t-25" style="margin-top: 30px">
                            <div class="col-sm-4 col-lg-4 thong-ke">
                                <div class="overview-item overview-item--c2">
                                    <div class="overview__inner">
                                        <div class="overview-box clearfix">
                                            <div class="icon">
                                                <i class="zmdi zmdi-shopping-cart"></i>
                                            </div>
                                            <div class="text">
                                                <h2>${numberOfMember}</h2>
                                                <span>Member</span>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-4 col-lg-4 thong-ke">
                                <div class="overview-item overview-item--c3">
                                    <div class="overview__inner">
                                        <div class="overview-box clearfix">
                                            <div class="icon">
                                                <i class="zmdi zmdi-calendar-note"></i>
                                            </div>
                                            <div class="text">
                                                <h2>${numberOfMovie}</h2>
                                                <span>Movie</span>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-4 col-lg-4 thong-ke">
                                <div class="overview-item overview-item--c4">
                                    <div class="overview__inner">
                                        <div class="overview-box clearfix">
                                            <div class="icon">
                                                <i class="zmdi zmdi-money"></i>
                                            </div>
                                            <div class="text">
                                                <h2>$${totalEarnings}</h2>
                                                <span>Total earnings</span>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END MAIN CONTENT-->




            <!-- list------------------------------------------------------------------- -->

            <div class="">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6">
                                <h2>Manage <b>Product</b></h2>
                                <c:if test="${message != null}">
                                    <p style="color: #5cb85c;">
                                        ${message}
                                    </p>
                                </c:if>
                            </div>
                            <div class="col-sm-6">
                                <a href="#addEmployeeModal"  class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Movie</span></a>
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Category Id</th>
                                <th>Name</th>
                                <th>Image</th>
                                <th>Description</th>
                                <th>Published Date</th>
                                <th>Is Free</th>
                                <th>Movie Link</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${lstMovie}" var="m">
                                <tr>

                                    <td>${m.id}</td>
                                    <td>${m.categoryId}</td>
                                    <td>${m.name}</td>
                                    <td>
                                        <img src="${m.image}">
                                    </td>
                                    <td>${m.description}</td>
                                    <td>${m.publishDate}</td>
                                    <td>${m.isFree}</td>
                                    <td>${m.movieLink}</td>
                                    <td>
                                        <a href="manage-movie?id=${m.id}"  class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                        <a href="manage-movie?id=${m.id}&action=delete" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </div>
            </div>
            <!-- Edit Modal HTML -->
            <div id="addEmployeeModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="manage-movie" method="post">
                            <div class="modal-header">						
                                <h4 class="modal-title">Add Movie</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>Name</label>
                                    <input name="name" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Image</label>
                                    <input name="image" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Movie Link</label>
                                    <input name="movieLink" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Description</label>
                                    <input name="description" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Is Free</label>
                                    <select name="isFree" class="form-select form-control" aria-label="Default select example">
                                        <option value="0">Not Free</option>
                                        <option value="1">Free</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Category</label>
                                    <select name="category" class="form-select form-control" aria-label="Default select example">
                                        <c:forEach items="${listCategory}" var="category">
                                            <option value="${category.id}">${category.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                <input type="submit" class="btn btn-success" name="action" value="Add">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- Edit Modal HTML -->
            <div id="editEmployeeModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="manage-movie" method="post">
                            <div class="modal-header">						
                                <h4 class="modal-title">Edit Movie</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <input name="id" type="hidden" class="form-control" required value="${movieDetail.id}">
                            <div class="modal-body">	
                                <div class="form-group">
                                    <label>Name</label>
                                    <input name="name" type="text" class="form-control" required value="${movieDetail.name}">
                                </div>
                                <div class="form-group">
                                    <label>Image</label>
                                    <input name="image" type="text" class="form-control" required value="${movieDetail.image}">
                                </div>
                                <div class="form-group">
                                    <label>Movie Link</label>
                                    <input name="movieLink" type="text" class="form-control" required value="${movieDetail.movieLink}">
                                </div>
                                <div class="form-group">
                                    <label>Description</label>
                                    <input name="description" type="text" class="form-control" required value="${movieDetail.description}">
                                </div>
                                <div class="form-group">
                                    <label>Is Free</label>
                                    <select name="isFree" class="form-select form-control" aria-label="Default select example">
                                        <option value="0" ${movieDetail.isFree == 0 ? "selected" : ""}>Not Free</option>
                                        <option value="1"  ${movieDetail.isFree == 1 ? "selected" : ""}>Free</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Category</label>
                                    <select name="category" class="form-select form-control" aria-label="Default select example">
                                        <c:forEach items="${listCategory}" var="category">
                                            <option value="${category.id}" <c:if test="${category.id == movieDetail.categoryId}">selected</c:if>>${category.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                <input type="submit" class="btn btn-info" name="action" value="Save">
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </a>
        <c:if test="${showEditDialog}">
            <script>$("#editEmployeeModal").modal('show');</script>
        </c:if>
    </div>
    <script src="js/manager.js" type="text/javascript"></script>        
</body>
</html>