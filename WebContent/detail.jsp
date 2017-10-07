<%@ page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="robots" content="all,follow">
    <meta name="googlebot" content="index,follow,snippet,archive">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Obaju e-commerce template">
    <meta name="author" content="Ondrej Svestka | ondrejsvestka.cz">
    <meta name="keywords" content="">

    <title>
        Obaju : e-commerce template
    </title>

    <meta name="keywords" content="">

    <link href='http://fonts.googleapis.com/css?family=Roboto:400,500,700,300,100' rel='stylesheet' type='text/css'>

    <!-- styles -->
    <link href="css/font-awesome.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/owl.carousel.css" rel="stylesheet">
    <link href="css/owl.theme.css" rel="stylesheet">

    <!-- theme stylesheet -->
    <link href="css/style.default.css" rel="stylesheet" id="theme-stylesheet">

    <!-- your stylesheet with modifications -->
    <link href="css/custom.css" rel="stylesheet">

    <script src="js/respond.min.js"></script>

    <link rel="shortcut icon" href="favicon.png">
	
</head>

<body>
      <!-- Header -->
   <jsp:include page="include/header.jsp"/>
   <!-- Header End -->

    <div id="all">

        <div id="content">
            <div class="container">

                <div class="col-md-12">
                    <ul class="breadcrumb">
                        <li><a href="#">Home</a>
                        </li>
                        <li><a href="#">카테고리1</a>
                        </li>
                        <li><a href="#">카테고리2</a>
                        </li>
                        <li>제품명</li>
                    </ul>

                </div>

               <!-- Side MenuBar -->
               <jsp:include page="include/sideMenu.jsp"></jsp:include>
               <!-- Side MenuBar End -->

                <div class="col-md-9">

                    <div class="row" id="productMain">
                        <div class="col-sm-6">
                            <div id="mainImage">
                                <img src="http://localhost/uploadphoto/${product.productImage}" alt="" class="img-responsive" name="productImage">
                            </div>


                            <!-- <div class="ribbon new">
                                <div class="theribbon">NEW</div>
                                <div class="ribbon-background"></div>
                            </div> -->
                            <!-- /.ribbon -->

                        </div>
                        <!-- 상품 정보 -->
                        <div class="col-sm-6">
                            <div class="box">
                                <h2 class="text-center" name="productName">${product.productName}</h2>
                                <hr width="300">
                                <p class="text-center">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <hr width="300">
                                <p class="price">${product.productPrice}원</p> <!-- 텍스트 크기 줄이기 -->

                                <p class="text-center buttons">
                                    <a href="basket.leaf" class="btn btn-default"><i class="fa fa-shopping-cart"></i> 장바구니</a> 
                                    <a href="basket.leaf" class="btn btn-default"><i class="fa fa-heart"></i> 바로 구매하기</a> 
                                </p>


                            </div>

                            
                        </div>

                    </div>


                    <!-- 상품 설명 탭 -->
                    <div class="box" id="details">
                      <ul id="explainTap" class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active">
                          <a data-target="#explain" id="explain-tab" role="tab" data-toggle="tab" aria-controls="explain" aria-expanded="true">상품정보</a></li>
                        <li role="presentation" class="">
                          <a data-target="#qna" role="tab" id="qna-tab" data-toggle="tab" aria-controls="qna" aria-expanded="false">상품문의</a></li>
                        <li role="presentation" class="">
                          <a data-target="#review" role="tab" id="review-tab" data-toggle="tab" aria-controls="review" aria-expanded="false">구매후기</a></li>
                     </ul>
                     <div id="myTabContent" class="tab-content">
                         <div role="tabpanel" class="tab-pane fade active in" id="explain" aria-labelledby="explain-tab">
                          <p>${product.productExplain }</p>
                         </div>
                         <div role="tabpanel" class="tab-pane fade" id="qna" aria-labelledby="qna">
                          <p>상품문의내용</p>
                          </div>
                          <div role="tabpanel" class="tab-pane fade" id="review" aria-labelledby="review-tab">
                           	<c:forEach items="${list}" var="i">
                           	<!-- List -->
                           	<div class="input-group">
                           		<div class="col-md-2">
									<p>${i.ctmNo}</p>
									<p>${i.reviewGrade}</p>
                           		</div>
                           		<div class="col-md-8">
                           			<p>${i.productCode}</p>
                           			<p>${i.reviewTitle}</p>
                           		</div>
                           		<div class="col-md-2">
                           			<p>${i.reviewDate}</p>
                           		</div>
                           	</div>
                           		<hr>
                           	</c:forEach>
                           <input type="button" value="리뷰쓰기" id="reviewbtn" class="btn btn-primary">
                          </div>
                    </div>
                    </div>
                </div>
                <!-- /.col-md-9 -->
            </div>
            <!-- /.container -->
        </div>
        <!-- /#content -->


        <!-- *** FOOTER ***
 _________________________________________________________ -->
        <div id="footer" data-animate="fadeInUp">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-6">
                        <h4>Pages</h4>

                        <ul>
                            <li><a href="text.leaf">About us</a>
                            </li>
                            <li><a href="text.leaf">Terms and conditions</a>
                            </li>
                            <li><a href="faq.leaf">FAQ</a>
                            </li>
                            <li><a href="contact.leaf">Contact us</a>
                            </li>
                        </ul>

                        <hr>

                        <h4>User section</h4>

                        <ul>
                            <li><a href="#" data-toggle="modal" data-target="#login-modal">Login</a>
                            </li>
                            <li><a href="register.leaf">Regiter</a>
                            </li>
                        </ul>

                        <hr class="hidden-md hidden-lg hidden-sm">

                    </div>
                    <!-- /.col-md-3 -->

                    <div class="col-md-3 col-sm-6">

                        <h4>Top categories</h4>

                        <h5>Men</h5>

                        <ul>
                            <li><a href="category.leaf">T-shirts</a>
                            </li>
                            <li><a href="category.leaf">Shirts</a>
                            </li>
                            <li><a href="category.leaf">Accessories</a>
                            </li>
                        </ul>

                        <h5>Ladies</h5>
                        <ul>
                            <li><a href="category.leaf">T-shirts</a>
                            </li>
                            <li><a href="category.leaf">Skirts</a>
                            </li>
                            <li><a href="category.leaf">Pants</a>
                            </li>
                            <li><a href="category.leaf">Accessories</a>
                            </li>
                        </ul>

                        <hr class="hidden-md hidden-lg">

                    </div>
                    <!-- /.col-md-3 -->

                    <div class="col-md-3 col-sm-6">

                        <h4>Where to find us</h4>

                        <p><strong>Obaju Ltd.</strong>
                            <br>13/25 New Avenue
                            <br>New Heaven
                            <br>45Y 73J
                            <br>England
                            <br>
                            <strong>Great Britain</strong>
                        </p>

                        <a href="contact.leaf">Go to contact page</a>

                        <hr class="hidden-md hidden-lg">

                    </div>
                    <!-- /.col-md-3 -->



                    <div class="col-md-3 col-sm-6">

                        <h4>Get the news</h4>

                        <p class="text-muted">Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>

                        <form>
                            <div class="input-group">

                                <input type="text" class="form-control">

                                <span class="input-group-btn">

			    <button class="btn btn-default" type="button">Subscribe!</button>

			</span>

                            </div>
                            <!-- /input-group -->
                        </form>

                        <hr>

                        <h4>Stay in touch</h4>

                        <p class="social">
                            <a href="#" class="facebook external" data-animate-hover="shake"><i class="fa fa-facebook"></i></a>
                            <a href="#" class="twitter external" data-animate-hover="shake"><i class="fa fa-twitter"></i></a>
                            <a href="#" class="instagram external" data-animate-hover="shake"><i class="fa fa-instagram"></i></a>
                            <a href="#" class="gplus external" data-animate-hover="shake"><i class="fa fa-google-plus"></i></a>
                            <a href="#" class="email external" data-animate-hover="shake"><i class="fa fa-envelope"></i></a>
                        </p>


                    </div>
                    <!-- /.col-md-3 -->

                </div>
                <!-- /.row -->

            </div>
            <!-- /.container -->
        </div>
        <!-- /#footer -->

        <!-- *** FOOTER END *** -->




        <!-- *** COPYRIGHT ***
 _________________________________________________________ -->
        <div id="copyright">
            <div class="container">
                <div class="col-md-6">
                    <p class="pull-left">© 2015 Your name goes here.</p>

                </div>
                <div class="col-md-6">
                    <p class="pull-right">Template by <a href="https://bootstrapious.com/e-commerce-templates">Bootstrapious</a> & <a href="https://fity.cz">Fity</a>
                         <!-- Not removing these links is part of the license conditions of the template. Thanks for understanding :) If you want to use the template without the attribution links, you can do so after supporting further themes development at https://bootstrapious.com/donate  -->
                    </p>
                </div>
            </div>
        </div>
        <!-- *** COPYRIGHT END *** -->



    </div>
    <!-- /#all -->


    

    <!-- *** SCRIPTS TO INCLUDE *** -->
        <script src="js/jquery-1.11.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.cookie.js"></script>
    <script src="js/waypoints.min.js"></script>
    <script src="js/modernizr.js"></script>
    <script src="js/bootstrap-hover-dropdown.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/front.js"></script>

<script>
//리뷰작성 버튼 클릭
$(document).ready(function(){
	$("#reviewbtn").click(function(){
		location.href = "review_write.leaf?productCode=${product.productCode}"
	})
});
</script>



</body>

</html>