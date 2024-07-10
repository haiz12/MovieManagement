<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>

<!-- Header Section Begin -->
<header class="header">
    <div class="container">
        <div class="row">
            <div class="col-lg-2">
                <div class="header__logo">
                    <a href="home">
                        <img src="img/logo.png" alt="">
                    </a>
                </div>
            </div>
            <div class="col-lg-8">
                <div class="header__nav">
                    <nav class="header__menu mobile-menu">
                        <ul>
                            <li class="active"><a href="home">Homepage</a></li>
                            <li><a href="movie-list">Categories <span class="arrow_carrot-down"></span></a>
                                <ul class="dropdown">
                                    <li><a href="movie-list">All Movie</a></li>
                                        <c:forEach items="${lstCategory}" var="c">
                                        <li><a href="movie-list?categoryId=${c.id}">${c.name}</a></li>
                                        </c:forEach>
                                </ul>
                            </li>
                            <li><a href="blog.jsp">Our Blog</a></li>
                                <c:if test="${empty sessionScope.acc}">
                                <li><a href="login">Member Registration</a></li>
                                </c:if>
                                <c:if test="${not empty sessionScope.acc}">
                                    <c:if test="${sessionScope.acc.isMember != 1}">
                                    <li><a href="member-register">Member Registration</a></li>
                                    </c:if>
                                </c:if>
                                <c:if test="${not empty sessionScope.acc}">
                                <li><a href="login">Logout</a></li>
                                </c:if>
                                <c:if test="${empty sessionScope.acc}">
                                <li><a href="login">Login</a></li>
                                </c:if>
                        </ul>
                    </nav>
                </div>
            </div>
            <div class="col-lg-2">
                <div class="header__right" style="color: white">
                    <c:if test="${not empty sessionScope.acc}">
                        <span>Welcome ${sessionScope.acc.name}</span> 
                        <span class="icon_profile"></span>
                    </c:if>
                </div>
            </div>
        </div>
        <div id="mobile-menu-wrap"></div>
    </div>
</header>
