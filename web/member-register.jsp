<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Anime Template">
    <meta name="keywords" content="Anime, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Member Register</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap"
    rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/plyr.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <style>
        .member-register:after{
            position: relative;
            text-align: center;
        }
        .login__form{
            text-align: center;
            padding-left: 0px;
        }
        .login__form form .input__item{
            margin: 0 auto;
            margin-bottom: 20px;
        }
        .login__form form .input__item input{
            height: initial;
            width: initial;
            transform: scale(2);
            margin: 10px;
        }
        .login__form form .input__item:before{
            position: relative;
        }
        .input__item{
            color: white;
            font-size: 20px;
        }
    </style>
</head>

<body>

    <!-- Normal Breadcrumb Begin -->
    <section class="normal-breadcrumb set-bg" data-setbg="img/normal-breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="normal__breadcrumb__text">
                        <h2>Member Register</h2>
                        <p>Welcome to the official MoviePRJ.</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Normal Breadcrumb End -->

    <!-- Signup Section Begin -->
    <section class="signup spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="login__form member-register">
                        <c:if test="${message != null}">
                            <h3 style="color: green">${message}</h3>
                        </c:if>
                        <h3>Member Register</h3>
                        <form action="member-register" method="post">
                            <div class="input__item">
                                <input type="radio" required="" name="price" id="price1" checked="" value="1">
                                <label class="form-check-label" for="price1">100.000 VND / 1 Month</label>
                            </div>
                            <div class="input__item">
                                <input type="radio" required="" name="price" id="price2" value="2">
                                <label class="form-check-label" for="price2">500.000 VND / 6 Months</label>
                            </div>
                            <div class="input__item">
                                <input type="radio" required="" name="price" id="price3" value="3">
                                <label class="form-check-label" for="price3">1.000.000 VND / 1 Years</label>
                            </div>
                            <c:if test="${message == null}">
                            <button type="submit" class="site-btn">Checkout Now</button>
                            </c:if>
                            <c:if test="${message != null}">
                                <a href="movie-list"><button type="button" class="site-btn">Watching Movie</button></a>
                            </c:if>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Signup Section End -->

<jsp:include page="common/footer.jsp"></jsp:include>

      <!-- Search model Begin -->
      <div class="search-model">
        <div class="h-100 d-flex align-items-center justify-content-center">
            <div class="search-close-switch"><i class="icon_close"></i></div>
            <form class="search-model-form">
                <input type="text" id="search-input" placeholder="Search here.....">
            </form>
        </div>
    </div>
    <!-- Search model end -->

    <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/player.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>

</body>

</html>