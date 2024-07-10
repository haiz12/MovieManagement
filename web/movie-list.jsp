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
        <title>Movie</title>

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
    </head>

    <body>
        <jsp:include page="common/header.jsp"></jsp:include>

            <!-- Breadcrumb Begin -->
            <div class="breadcrumb-option">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="breadcrumb__links">
                                <a href="home"><i class="fa fa-home"></i> Home</a>
                                <a href="movie-list">Categories</a>
                                <span>${category == null ? "All Movie" : category.name}</span>
                        </div>
                    </div>
                    <div class="col-lg-12" style="padding-top: 30px">
                        <form action="" method="get">
                            <div class="breadcrumb__links">
                                <input type="hidden" name="categoryId" value="${category.id}"/>
                                <input type="hidden" name="sort" value="${sort}"/>
                                <span style="color: white">Search: </span>
                                <input type="text" name="txtSearch" value="${txtSearch}"/>
                                <input type="submit" value="Search"/>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
        <!-- Breadcrumb End -->

        <!-- Product Section Begin -->
        <section class="product-page spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="product__page__content">
                            <div class="product__page__title">
                                <div class="row">
                                    <div class="col-lg-8 col-md-8 col-sm-6">
                                        <div class="section-title">
                                            <h4>${category == null ? "All Movie" : category.name}</h4>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-6">
                                        <div class="product__page__filter">
                                            <p>Order by:</p>
                                            <select name="sort" onchange="sortName()" id="sort">
                                                <option value="asc" ${sort eq "asc" ? "selected" : ""}>A-Z</option>
                                                <option value="desc" ${sort eq "desc" ? "selected" : ""}>Z-A</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <c:forEach items="${lstMovie}" var="m">
                                    <div class="col-lg-4 col-md-6 col-sm-6">
                                        <div class="product__item">
                                            <div class="product__item__pic set-bg" data-setbg="${m.image}">
                                                <div class="ep">18 / 18</div>
                                                <div class="comment"><i class="fa fa-comments"></i> 11</div>
                                                <div class="view"><i class="fa fa-eye"></i> 9141</div>
                                            </div>
                                            <div class="product__item__text">
                                                <ul>
                                                    <li>Active</li>
                                                    <li>Movie</li>
                                                </ul>
                                                <h5><a href="movie-detail?id=${m.id}">${m.name}</a></h5>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="product__pagination">
                            <c:forEach begin="1" end="${totalPage}" var="i">
                                <a href="movie-list?categoryId=${category.id}&txtSearch=${txtSearch}&sort=${sort}&pageIndex=${i}" class="${pageIndex == i ? "current-page":""}">${i}</a>
                            </c:forEach>
                            <!--                            <a href="#" class="current-page">1</a>
                                                        <a href="#">2</a>
                                                        <a href="#">3</a>
                                                        <a href="#">4</a>
                                                        <a href="#">5</a>
                                                        <a href="#"><i class="fa fa-angle-double-right"></i></a>-->
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-8">
                        <div class="product__sidebar">
                            <div class="product__sidebar__view">
                                <div class="section-title">
                                    <h5>Top Views</h5>
                                </div>
                                <ul class="filter__controls">
                                    <li class="active" data-filter="*">Day</li>
                                    <li data-filter=".week">Week</li>
                                    <li data-filter=".month">Month</li>
                                    <li data-filter=".years">Years</li>
                                </ul>
                                <div class="filter__gallery">
                                    <div class="product__sidebar__view__item set-bg mix day years"
                                         data-setbg="img/sidebar/tv-1.jpg">
                                        <div class="ep">18 / ?</div>
                                        <div class="view"><i class="fa fa-eye"></i> 9141</div>
                                        <h5><a href="#">Boruto: Naruto next generations</a></h5>
                                    </div>
                                    <div class="product__sidebar__view__item set-bg mix month week"
                                         data-setbg="img/sidebar/tv-2.jpg">
                                        <div class="ep">18 / ?</div>
                                        <div class="view"><i class="fa fa-eye"></i> 9141</div>
                                        <h5><a href="#">The Seven Deadly Sins: Wrath of the Gods</a></h5>
                                    </div>
                                </div>
                            </div>
                            <div class="product__sidebar__comment">
                                <div class="section-title">
                                    <h5>New Comment</h5>
                                </div>
                                <div class="product__sidebar__comment__item">
                                    <div class="product__sidebar__comment__item__pic">
                                        <img src="img/sidebar/comment-1.jpg" alt="">
                                    </div>
                                    <div class="product__sidebar__comment__item__text">
                                        <ul>
                                            <li>Active</li>
                                            <li>Movie</li>
                                        </ul>
                                        <h5><a href="#">The Seven Deadly Sins: Wrath of the Gods</a></h5>
                                        <span><i class="fa fa-eye"></i> 19.141 Viewes</span>
                                    </div>
                                </div>
                                <div class="product__sidebar__comment__item">
                                    <div class="product__sidebar__comment__item__pic">
                                        <img src="img/sidebar/comment-2.jpg" alt="">
                                    </div>
                                    <div class="product__sidebar__comment__item__text">
                                        <ul>
                                            <li>Active</li>
                                            <li>Movie</li>
                                        </ul>
                                        <h5><a href="#">Shirogane Tamashii hen Kouhan sen</a></h5>
                                        <span><i class="fa fa-eye"></i> 19.141 Viewes</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Product Section End -->

        <jsp:include page="common/footer.jsp"></jsp:include>
            <!-- Js Plugins -->
            <script src="js/jquery-3.3.1.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/player.js"></script>
            <script src="js/jquery.nice-select.min.js"></script>
            <script src="js/mixitup.min.js"></script>
            <script src="js/jquery.slicknav.js"></script>
            <script src="js/owl.carousel.min.js"></script>
            <script src="js/main.js"></script>

            <script type="text/javascript">
                                                function sortName() {
                                                    var sort = document.getElementById("sort");
                                                    window.location.href = 'movie-list?categoryId=${category.id}&txtSearch=${txtSearch}&sort=' + sort.value;
                                                }

        </script>

    </body>

</html>