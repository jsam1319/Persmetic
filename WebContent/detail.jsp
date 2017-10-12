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
						<li><a href="index.leaf">Home</a></li>
						<li><a id="category1" href="list_item.leaf?category_no=${product.categoryNo}"></a></li>
						<li>${product.productName}</li>
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
						</div>
						<!-- 상품 정보 -->
						<div class="col-sm-6">
							<div class="box">
								<h2 class="text-center" name="productName">${product.productName}</h2>
								<hr width="300">
								<p class="text-center"></p>
                                <div class="text-center"><p id="grade">
                                <i class='fa fa-star'></i><i class='fa fa-star'></i><i class='fa fa-star'></i><i class='fa fa-star'></i><i class='fa fa-star'></i>
                                </p></div>
                                <hr width="300">
								<hr width="300">
								<p class="price">${product.productPrice}원</p>
								<!-- 텍스트 크기 줄이기 -->

								<p class="text-center buttons">
									<a href="#" 
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
								aria-labelledby="qna-tab">
								<p>상품문의내용</p>
							</div>

							<!-- Review탭 -->
							<div role="tabpanel" class="tab-pane fade" id="review"
								aria-labelledby="review-tab">
							</div>

						</div>
					</div>
					
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
		/** 장바구니버튼 클릭 이벤트*/
		window.onload = function() {
			setCreateButton();
			print();
		};
		setCreateButton = function() {
			var buttons = $("a[name=cart_create]");
			
			buttons.click(function() {
				$.ajax({
					url : 'cart_create.leaf',
					data : {
							'product_code' : "${product.productCode}",
							'cart_quantity' : 1,
							'cart_price' : "${product.productPrice}"
					},
					success : function() {
						alert("장바구니 담기 완료!");
						$.ajax({
							url :$.ajax({
								url : "log.leaf",
								data : {
									'type' : 'CART_INSERT',
									'content' : $("a[name=cart_create]")
								},
								success : function(msg) {
									console.log(msg);
								}
							}) 
						})
					},
					error : function(request) {
						console.log(request);
						alert("장바구니에 담겨있는 상품입니다.");
						//return false;
					}
				})
			})

			for (var i = 0; i < buttons.length; i++) {
				console.log(buttons.get(i).href);
			}
		}
		
		
		$(document).ready(function() {
			/** 리뷰 페이지 load */
			  $("#review-tab").click(function(){
				$("#review").load("reviewList.leaf?page=1&product_code=${product.productCode}")
			})
			
			/** grade 찍기 */
			/* var grade="";
			  for(var g=0; g<${product.grade}; g++){
				  grade += "<i class='fa fa-star'></i>"
			  }
			  $("#grade").html(grade); */
		});
		
	 	
 	 	function print(){
 			var ctg = "";
	 		switch("${product.categoryNo}"){
	 		case 110 :	ctg+="파운데이션"; break;
	 		case 120 :	ctg+="쿠션"; break;
	 		case 130 :	ctg+="파우더&컴팩트"; break;
			case 140 :	ctg+="메이크업 베이스&컨실러"; break;
 			case 150 :	ctg+="블러셔&하이라이터"; break;
	 		case 210 :	ctg+="마스카라"; break;
	 		case 220 :	ctg+="아이섀도"; break;
	 		case 230 :	ctg+="아이브로우"; break;
	 		case 310 :	ctg+="립스틱"; break;
	 		case 320 :	ctg+="틴트&립글로즈"; break;
	 		default	:	return; break;
	 		}
 			console.log(ctg)
 			$("#category1").append(ctg);
	}
	</script>


</body>

</html>