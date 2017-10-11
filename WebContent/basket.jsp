<%@ page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<script>
  window.onload = function() {
   	total();
   	setDeleteButton();
   	code();
   	$("#goOrder").click(function() {
   		$(this).attr('href', "orderitem_create.leaf?ctm_no=${cookie.customer.value}&product_code=" + codes);
   		console.log($(this).attr("href"));
   	})
}
    
// 총 상품 합계
total = function(){
   var prices=document.getElementsByName("totalPrice");
   var sum = 0;
   
   for(var i=0; i<prices.length; i++){
   	sum = sum + parseInt(prices[i].innerHTML);
   }
	document.getElementById("total").innerHTML = sum + "원";
}

setDeleteButton = function() {
	var buttons = $("a[name=cart_delete]");
	console.log(buttons);

	for(var i=0; i<buttons.length; i++) {
		console.log(buttons.get(i).href);
	}
}

var codes = "";

code = function(){
	var pcode = document.getElementsByName("code");
	for(var i=0; i<pcode.length; i++){
		if(i==0) 
			codes = codes + pcode[i].getAttribute("value");
		else
			codes = codes + "," + pcode[i].getAttribute("value");  //value : productCode값
	}
}



</script>




    <meta charset="utf-8">
    <meta name="robots" content="all,follow">
    <meta name="googlebot" content="index,follow,snippet,archive">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Obaju e-commerce template">
    <meta name="author" content="Ondrej Svestka | ondrejsvestka.cz">
    <meta name="keywords" content="">

    <title>장바구니</title>

    <meta name="keywords" content="">

    <link href='http://fonts.googleapis.com/css?family=Roboto:400,500,700,300,100' rel='stylesheet' type='text/css'>

    <!-- styles -->
    <link href="css/font-awesome.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">
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
                        <li>장바구니</li>
                    </ul>
                </div>

                <div class="col-md-12" id="basket">

                    <div class="box">

                            <h1>장바구니</h1>
                              <p class="text-muted">${requestScope.list.size() }개의 상품이 담겨 있습니다.</p>
                            
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
                                        <td colspan="8" style="text-align: center; color: red;">담긴 상품이 존재하지 않습니다.</td>
                                      </tr>
                                    </c:when>
                                    <c:otherwise>
                                    <c:forEach var="cart" items="${requestScope.list }">
                                      <tr name="${cart.cartNo}">
                                        <td><input id="${cart.cartNo}" type="checkbox" checked></td>
                                        <td><img src="${cart.productImage}"></td>
                                        <td colspan="2"  name="code" value="${cart.productCode }">${cart.productName }</a></td>
                                        <td><input type="number" value="${cart.cartQuantity }"></td>
                                        <td>${cart.cartPrice }원</td>
                                        <td><span name="totalPrice">${cart.cartPrice*cart.cartQuantity}</span>원</td>
                                        <td><a href="cart_delete.leaf?product_code=${cart.productCode}&ctm_no=${cookie.customer.value}" name="cart_delete"><i class="fa fa-trash-o"></i></a></td>
                                      </tr>
                                    </c:forEach>
                                    </c:otherwise>
                                  </c:choose>
                                    </tbody>

                                 
                                    <tfoot>
                                        <tr>
                                            <th colspan="7" class="text-right">총 합계</th>
                                            <th colspan="1" class="text-center"><span id="total">원</span></th>
                                        </tr>
                                    </tfoot>
                                </table>

                            </div>
                            <!-- /.table-responsive -->

                            <div class="box-footer">
                                <div class="pull-left">
                                    <a href="category.leaf" class="btn btn-default"><i class="fa fa-chevron-left"></i>쇼핑 계속하기</a>
                                </div>
                                <div class="pull-right">
                                    <button class="btn btn-default" style="margin-right: 10px">선택 상품 주문하기</button>
                                    
                                      <a href="#" class="btn btn-primary" id="goOrder"><i class="fa fa-shopping-cart"></i>주문하러가기</a> 
                                </div>
                            </div>
                    </div>
                    <!-- /.box -->


           


                </div>
                <!-- /.col-md-9 -->

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


    

    <!-- *** SCRIPTS TO INCLUDE ***
 _________________________________________________________ -->
    <script src="js/jquery-1.11.0.min.js"></script>
    <script src="js/bootstrap.min.js">
    