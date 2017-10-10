<%@ page contentType="text/html; charset=utf-8"%>
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

<title>상품정보</title>

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
						<li><a href="#">카테고리1</a></li>
						<li><a href="#">카테고리2</a></li>
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

								<img src="http://localhost/uploadphoto/${product.productImage}"
									alt="" class="img-responsive" name="productImage">
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
									<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i>
								<hr width="300">
								<p class="price">${product.productPrice}원</p>
								<!-- 텍스트 크기 줄이기 -->

								<p class="text-center buttons">
									<a href="cart_create.leaf?ctm_no=${cookie.customer.value}"
										name="cart_create" class="btn btn-default"><i
										class="fa fa-trash-o"></i>장바구니</a> <a href="basket.leaf"
										class="btn btn-default"><i class="fa fa-heart"></i> 바로
										구매하기</a>
								</p>
							</div>
						</div>
					</div>
					
					<div class="box" id="details">
						<ul id="explainTap" class="nav nav-tabs" role="tablist">
							<li role="presentation" class="active"><a
								data-target="#explain" id="explain-tab" role="tab"
								data-toggle="tab" aria-controls="explain" aria-expanded="true">상품정보</a></li>
							<li role="presentation" class=""><a data-target="#qna"
								role="tab" id="qna-tab" data-toggle="tab" aria-controls="qna"
								aria-expanded="false">상품문의</a></li>
							<li role="presentation" class=""><a data-target="#review"
								role="tab" id="review-tab" data-toggle="tab"
								aria-controls="review" aria-expanded="false">구매후기</a></li>
						</ul>
						<div id="myTabContent" class="tab-content">
							<div role="tabpanel" class="tab-pane fade active in" id="explain"
								aria-labelledby="explain-tab">
								<p>${product.productExplain }</p>
							</div>
							<div role="tabpanel" class="tab-pane fade" id="qna"
								aria-labelledby="qna">
								<p>상품문의내용</p>
							</div>

							<!-- Review탭 -->
							<div role="tabpanel" class="tab-pane fade" id="review"
								aria-labelledby="review-tab">
							</div>

						</div>
					</div>
					
					<!-- 상품 설명 탭 -->
					<%-- <div class="box" id="details">
						<ul id="explainTap" class="nav nav-tabs" role="tablist">
							<li><a href="#explain">상품정보</a></li>
							<li><a href="#qna">상품문의</a></li>
							<li><a href="#review">구매후기</a></li>
						</ul>
						<section id="explain">
						<div id="myTabContent" class="tab-content">
							<div role="tabpanel">
								<p>${product.productExplain }</p>
								<p>productExplain</p>
							</div>
							</div>
							</section>
							<section id="qna">
							<div role="tabpanel">
								<p>상품문의내용</p>
							</div>
							</section>

							<!-- Review탭 -->
							<section id="review">
							<div role="tabpanel">
							<div id="all">
<!-- +++++++++++++++++++++ productCode, ctmName 가져오기 / 리스트띄우기 -->
		<div id="content">
			<div class="container">
					<div class="row reviews">
						<!-- review -->
						<div>
						<hr>
						<c:set var="productCode" value="${product.productCode}"/>
							<c:forEach items="${list}" var="i">
						<c:set var="ckproductCode" value="${i.productCode}"/>
								<c:if test="${productCode eq ckproductCode}">
								<div>
								<div class="col-md-1">
									<p>${i.ctmName}</p>
									<p>grade:${i.reviewGrade}</p>
								</div>
								<div class="col-md-5">
									<p>productCode:${i.productCode}</p>
									<p>title:${i.reviewTitle}</p>
								</div>
								<div class="col-md-2">
									<p>date:${i.reviewDate}</p>
								</div>
								</div>
								<div class="col-md-12">
								<hr >
								</div>
								</c:if>
							</c:forEach>

						</div>
						<!-- /.review -->
						<c:choose>
							<c:when test="${!empty cookie.customer}">
							<div class="col-md-12">
								<input type="button" value="리뷰쓰기" id="reviewbtn"
									class="btn btn-primary">
									</div>
							</c:when>
						</c:choose>
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
										href="${pageBuilder.getQueryString(pageBuilder.getPreviousStartPage())}">
											< </a></li>
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
										href="${pageBuilder.getQueryString(pageBuilder.getNextStartPage())}">
											> </a></li>
								</c:if>

								<c:if test="${pageBuilder.isShowLast()}">
									<li><a
										href="${pageBuilder.getQueryString(pageBuilder.getTotalPageCount())}">
											>> </a></li>
								</c:if>

							</ul>
						</nav>
					</div>

					<!-- /.Paging -->
			</div>
			<!-- /.container -->
		</div>
	</div>
							</div>
							</section>

						</div> --%>
					</div>
				</div>
				<!-- /.col-md-9 -->
			</div>
			<!-- /.container -->
		</div>
		<!-- /#content -->


		<!-- Footer -->
		<jsp:include page="include/footer.jsp"></jsp:include>
		<!-- /.Footer -->

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
		window.onload = function() {
			setCreateButton();
		};
		setCreateButton = function() {
			var buttons = $("a[name=cart_create]");
			console.log(buttons);

			for (var i = 0; i < buttons.length; i++) {
				console.log(buttons.get(i).href);
			}
		}
		
		$(document).ready(function() {
			  $("#review-tab").click(function(){
				$("#review").load("${pageContext.servletContext.contextPath}/reviewList.leaf?page=1&product_code=${product.productCode}")
			})
		});
	</script>


</body>

</html>