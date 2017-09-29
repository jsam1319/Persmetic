<%@ page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="robots" content="all,follow">
    <meta name="googlebot" content="index,follow,snippet,archive">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Obaju e-commerce template">
    <meta name="author" content="Ondrej Svestka | ondrejsvestka.cz">
    <meta name="keywords" content="">

    <title>주문(결제방식)</title>

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
                    <li>주문/결제</li>
                </ul>
            </div>

            <div class="col-md-12" id="checkout">

                    <div class="box">

                        <form method="post" action="order-address.leaf">

                            <h1>주문항목</h1>
                              <p class="text-muted">${requestScope.list.size() }개의 상품을 주문합니다.</p>
                            
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>선택</th>
                                            <th>이미지</th>
                                            <th colspan="2">상품명</th>
                                            <th>수량</th>
                                            <th>판매가</th>
                                            <th >합계</th>
                                            <th>상품삭제</th>
                                        </tr>
                                    </thead>
                                    
                                    <tbody>
                                 <c:choose>
                                    <c:when test="${empty list }">
                                      <tr>
                                        <td colspan="8" style="text-align: center; color: red;">주문할 상품이 존재하지 않습니다.</td>
                                      </tr>
                                    </c:when>
                                    <c:otherwise>
                                    <c:forEach var="cart" items="${requestScope.list }">
                                      <tr>
                                        <td><input type="checkbox"></td>
                                        <td>이미지</td>
                                        <td colspan="2"><a href="mailto:">${cart.ctmNo }</a></td>
                                        <td>${cart.cartQuantity }</td>
                                        <td>${cart.cartPrice }원</td>
                                        <td><span name="totalPrice">${cart.cartPrice*cart.cartQuantity}</span>원</td>
                                        <td><a href="#"><i class="fa fa-trash-o"></i></a></td>
                                      </tr>
                                    </c:forEach>
                                    </c:otherwise>
                                  </c:choose>
                                    </tbody>
                            
                                    <tfoot>
                                        <tr><th colspan="8"></th></tr>
                                    </tfoot>
                                </table>

                            </div>
                            <!-- /.table-responsive -->


                        </form>

                    </div>


  <div class="col-md-9" id="checkout">


                    <div class="box">
                        <form method="post" action="order-delivery.leaf">
                            <h1>결제방식</h1>
                            <ul class="nav nav-pills nav-justified">
                                <li><a href="order-address.leaf"><i class="fa fa-map-marker"></i><br>배송지정보</a>
                                </li>
                                <li class="active"><a href="#"><i class="fa fa-money"></i><br>결제방식</a>
                                </li>
                            </ul>

                            <div class="content">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="box payment-method">

                                            <h4>신용카드</h4>

                                            <p>Credit card</p>

                                            <div class="box-footer text-center">

                                                <input type="radio" name="payment" value="payment1">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="box payment-method">

                                            <h4>실시간 계좌이체</h4>

                                            <p>Real-time account transfer</p>

                                            <div class="box-footer text-center">

                                                <input type="radio" name="payment" value="payment2">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-sm-6">
                                        <div class="box payment-method">

                                            <h4>무통장입금</h4>

                                            <p>make a deposit</p>

                                            <div class="box-footer text-center">

                                                <input type="radio" name="payment" value="payment3">
                                            </div>
                                        </div>
                                    </div>
                                    
                                     <div class="col-sm-6">
                                        <div class="box payment-method">

                                            <h4>휴대폰결제</h4>

                                            <p>Cell phone payment</p>

                                            <div class="box-footer text-center">

                                                <input type="radio" name="payment" value="payment3">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.row -->

                            </div>
                            <!-- /.content -->

                            <div class="box-footer">
                                <div class="pull-left">
                                    <a href="order-address.leaf" class="btn btn-default"><i class="fa fa-chevron-left"></i>뒤로 가기</a>
                                </div>
                                <div class="pull-right">
                                    <button type="submit" class="btn btn-primary">결제하기<i class="fa fa-chevron-right"></i>
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <!-- /.box -->


                </div>
                <!-- /.col-md-9 -->

                    <div class="col-md-3">

                    <div class="box" id="order-summary">
                        <div class="box-header">
                            <h3>주문 요약</h3>
                        </div>
                        <p class="text-muted">배송 및 추가 비용은 입력한 값을 기준으로 계산됩니다.</p>

                        <div class="table-responsive">
                            <table class="table">
                                <tbody>
                                    <tr>
                                        <td>주문 총 합계</td>
                                        <th>0원</th>
                                    </tr>
                                    <tr class="total">
                                        <td>총 합계</td>
                                        <th>0원</th>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                    </div>

                </div>

                <!-- /.col-md-3 -->

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
                    <p class="pull-left">Â© 2015 Your name goes here.</p>

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
    </div>
    <!-- /#all -->


    

    <!-- *** SCRIPTS TO INCLUDE ***
 _________________________________________________________ -->
    <script src="js/jquery-1.11.0.min.js"></script>
    <script src="js/bootstrap.min.js">