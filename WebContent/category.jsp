<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>Obaju : e-commerce template</title>

<meta name="keywords" content="">

<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,500,700,300,100'
	rel='stylesheet' type='text/css'>

<!-- styles -->
<link href="css/font-awesome.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/owl.carousel.css" rel="stylesheet">
<link href="css/owl.theme.css" rel="stylesheet">

<!-- theme stylesheet -->
<link href="css/style.default.css" rel="stylesheet"
	id="theme-stylesheet">

<!-- your stylesheet with modifications -->
<link href="css/custom.css" rel="stylesheet">

<script src="js/respond.min.js"></script>

<link rel="shortcut icon" href="favicon.png">

<style>
.img-responsive {
	height: 200px;
}
</style>


</head>

<body>
	<!-- Header -->
	<jsp:include page="include/header.jsp" />
	<!-- Header End -->

	<div id="all">

		<div id="content">
			<div class="container">

				<div class="col-md-12">
					<ul class="breadcrumb">
						<li><a href="#">Home</a></li>
						<li>Ladies</li>
					</ul>
				</div>


				<!-- Side MenuBar -->
				<jsp:include page="include/sideMenu.jsp"></jsp:include>
				<!-- Side MenuBar End -->


				<div class="col-md-9">
					<div class="box">
						<h1>Ladies</h1>
						<p>In our Ladies department we offer wide selection of the
							best products we have found and carefully selected worldwide.</p>
					</div>

					<div class="box info-bar">
						<div class="row">
							<div class="col-sm-12 col-md-4 products-showing">
								Showing <strong>12</strong> of <strong>25</strong> products
							</div>

							<div class="col-sm-12 col-md-8  products-number-sort">
								<div class="row">
									<form class="form-inline">
										<div class="col-md-6 col-sm-6">
											<div class="products-number">
												<strong>Show</strong> <a href="#"
													class="btn btn-default btn-sm btn-primary">12</a> <a
													href="#" class="btn btn-default btn-sm">24</a> <a href="#"
													class="btn btn-default btn-sm">All</a> products
											</div>
										</div>
										<div class="col-md-6 col-sm-6">
											<div class="products-sort-by">
												<strong>Sort by</strong> <select name="sort-by"
													class="form-control">
													<option>Price</option>
													<option>Name</option>
													<option>Sales first</option>
												</select>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>

					<div class="row products">
						<div class="col-md-12 col-sm-6">

							<c:forEach items="${list}" var="i">
								<!--List -->
								<div class="product col-md-4 col-sm-3">
									<a href="detail_item.leaf?product_code=${i.productCode}" class="image"> <img
										src="http://localhost/uploadphoto/${i.productImage}"
										alt="image" class="img-responsive">
									</a>
									<div class="content">
										<h3>
											<a href="detail_item.leaf?product_code=${i.productCode}">${i.productName}</a>
										</h3>
										<p class="price">${i.productPrice}원</p>
										<p class="buttons">
											<a href="detail_item.leaf?product_code=${i.productCode}" class="btn btn-default">상세보기</a>&nbsp;&nbsp;
											<a href="#" value="${i.productCode}" name="addToCart" class="btn btn-primary"><i
												class="fa fa-shopping-cart"></i>장바구니</a>
										</p>
									</script>
                 
									</div>
								</div>
							</c:forEach>
							<!-- /.text -->
						</div>
						<!-- /.product -->
					</div>
					<!-- /.products -->

					 <!-- Paging -->
					<div class="pages">

						<nav aria-label="Page navigation">
								<ul class="pagination">
									<c:if test="${pageBuilder.isShowFirst()}">
										<li><a href="${pageBuilder.getQueryString(1)}"> << </a></li>
									</c:if>

									<c:if test="${pageBuilder.isShowPrevious()}">
										<li class="prev"><a
											href="${pageBuilder.getQueryString(pageBuilder.getPreviousStartPage())}"> < </a></li>
									</c:if>

									<c:forEach var="i" begin="${pageBuilder.currentStartPage }"
										end="${pageBuilder.currentEndPage}" varStatus="status">
										<c:choose>
											<c:when test="${i==params.page}">
												<li class="active"><a>${i}</a></li>
											</c:when>
											<c:otherwise>
												<li><a href="${pageBuilder.getQueryString(i)}">${i}</a></li>
											</c:otherwise>
										</c:choose>
									</c:forEach>

									<c:if test="${pageBuilder.isShowNext()}">
										<li class="next"><a
											href="${pageBuilder.getQueryString(pageBuilder.getNextStartPage())}"> > </a></li>
									</c:if>

									<c:if test="${pageBuilder.isShowLast()}">
										<li><a
											href="${pageBuilder.getQueryString(pageBuilder.getTotalPageCount())}"> >> </a></li>
									</c:if>

								</ul>
							</nav>
					</div>

					<!-- /.Paging --> 

					


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
							<li><a href="text.leaf">About us</a></li>
							<li><a href="text.leaf">Terms and conditions</a></li>
							<li><a href="faq.leaf">FAQ</a></li>
							<li><a href="contact.leaf">Contact us</a></li>
						</ul>

						<hr>

						<h4>User section</h4>

						<ul>
							<li><a href="#" data-toggle="modal"
								data-target="#login-modal">Login</a></li>
							<li><a href="register.leaf">Regiter</a></li>
						</ul>

						<hr class="hidden-md hidden-lg hidden-sm">

					</div>
					<!-- /.col-md-3 -->

					<div class="col-md-3 col-sm-6">

						<h4>Top categories</h4>

						<h5>Men</h5>

						<ul>
							<li><a href="category.leaf">T-shirts</a></li>
							<li><a href="category.leaf">Shirts</a></li>
							<li><a href="category.leaf">Accessories</a></li>
						</ul>

						<h5>Ladies</h5>
						<ul>
							<li><a href="category.leaf">T-shirts</a></li>
							<li><a href="category.leaf">Skirts</a></li>
							<li><a href="category.leaf">Pants</a></li>
							<li><a href="category.leaf">Accessories</a></li>
						</ul>

						<hr class="hidden-md hidden-lg">

					</div>
					<!-- /.col-md-3 -->

					<div class="col-md-3 col-sm-6">

						<h4>Where to find us</h4>

						<p>
							<strong>Obaju Ltd.</strong> <br>13/25 New Avenue <br>New
							Heaven <br>45Y 73J <br>England <br> <strong>Great
								Britain</strong>
						</p>

						<a href="contact.leaf">Go to contact page</a>

						<hr class="hidden-md hidden-lg">

					</div>
					<!-- /.col-md-3 -->



					<div class="col-md-3 col-sm-6">

						<h4>Get the news</h4>

						<p class="text-muted">Pellentesque habitant morbi tristique
							senectus et netus et malesuada fames ac turpis egestas.</p>

						<form>
							<div class="input-group">

								<input type="text" class="form-control"> <span
									class="input-group-btn">

									<button class="btn btn-default" type="button">Subscribe!</button>

								</span>

							</div>
							<!-- /input-group -->
						</form>

						<hr>

						<h4>Stay in touch</h4>

						<p class="social">
							<a href="#" class="facebook external" data-animate-hover="shake"><i
								class="fa fa-facebook"></i></a> <a href="#" class="twitter external"
								data-animate-hover="shake"><i class="fa fa-twitter"></i></a> <a
								href="#" class="instagram external" data-animate-hover="shake"><i
								class="fa fa-instagram"></i></a> <a href="#" class="gplus external"
								data-animate-hover="shake"><i class="fa fa-google-plus"></i></a>
							<a href="#" class="email external" data-animate-hover="shake"><i
								class="fa fa-envelope"></i></a>
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
					<p class="pull-right">
						Template by <a
							href="https://bootstrapious.com/e-commerce-templates">Bootstrapious</a>
						& <a href="https://fity.cz">Fity</a>
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
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.cookie.js"></script>
	<script src="js/waypoints.min.js"></script>
	<script src="js/modernizr.js"></script>
	<script src="js/bootstrap-hover-dropdown.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/front.js"></script>


	<script>
	
		window.onload = function() {
			
			var addButton = $("a[name=addToCart]");
			
			
			addButton.click(function() {
				var pPrice = $(this).parent().siblings().filter("p.price");
				var price = pPrice.html();
				var priceNum = price.split("원")[0];
				
				$.ajax({
					url : "cart_create.leaf",
					data : {
						'product_code' : $(this).attr('value'),
						'ctm_no' : "${cookie.customer.value}",
						'cart_quantity' : 1,
						'cart_price' : priceNum
					},
					success : function(request) {
						console.log(request);
						alert("장바구니 넣기 성공!");
						//return false;
					},
					error : function(request) {
						console.log(request);
						alert("장바구니에 담겨있는 상품입니다.");
						//return false;
					}
				})
			})
		}
	</script>


</body>

</html>