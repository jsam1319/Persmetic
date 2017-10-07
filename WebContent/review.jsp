<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<head>
<meta charset="utf-8">
<meta name="robots" content="all,follow">
<meta name="googlebot" content="index,follow,snippet,archive">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Obaju e-commerce template">
<meta name="author" content="Ondrej Svestka | ondrejsvestka.cz">
<meta name="keywords" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/css/bootstrap.min.css" rel="stylesheet">

<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,500,700,200,100'
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
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<style>
hr.bl {
	color: black;
}
</style>
<script>
$(document).ready(function(){
	/** 리뷰 등록 */
	$("#btnSubmit").click(function() {
		var data = $("#review_form").serialize();	

		$.ajax({
			url : 'review/create.leaf',
			data : param,
			dataType : 'json',
			type : 'POST',
			success : function(msg) {
				location.href = "/detail_item.leaf"
			},
			error : function(msg) {
				alert(msg)
			}
		});

		alert("리뷰등록완료!");
		location.href = "/detail_item.leaf";
		})

	})
})
</script>

<title>리뷰 등록</title>
</head>
<body>

	<%-- <c:if test="${empty sessionScope.id}">
  <meta http-equiv="Refresh" content="0;url=/login.leaf">
</c:if> --%>


	<!-- Title -->
	<div class="panel panel-default">
		<div class="panel-heading" align="center">
			<h2>리뷰 작성</h2>
		</div>
		<!-- Title End -->

		<!-- Body -->
		<div class="panel-body">

			<div class="container">

				<div class="row">


					<div class="container">

						<div class="row">

							<form method="post" id="review_form">
								<input type="text" name="ctmno" value="${sessionScope.id}">(닉네임)님
								<hr class="bl">
								<div>
									<div>
										<!-- <div class="col-md-2">
									<div id="review_image"></div>
									<div>
										<input type="file" name="image" accept="" id="upload">
									</div>
								</div> -->

										<div class="col-md-2">
											<img
												src="http://localhost/uploadphoto/${product.productImage}"
												alt="상품이미지" class="img-responsive">
										</div>
										<div class="col-md-10">
											<div class="form-group">
												<label for="name">${product.productName} </label>
											</div>
										</div>
									</div>
									<div class="col-md-12">
										<hr class="bl">
									</div>
									<div>
										<div class="col-md-2">별점</div>
										<div class="col-md-10" id="grade" name="grade">
											<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i> <i class="fa fa-star"></i> <i
												class="fa fa-star"></i>
										</div>
									</div>
									<div class="col-md-12">
										<hr>
									</div>
									<div>
										<div class="col-md-2">상품평</div>
										<div class="col-md-10">
											<textarea name="content" id="content" class="form-control"
												style="width: 100%; height: 100px;"
												placeholder="상품평을 입력해주세요"></textarea>
										</div>
									</div>
									<div class="col-md-12">
										<hr>
									</div>
									<div>
										<div class="col-md-2">사진첨부</div>
										<div class="col-md-10">첨부하기 버튼</div>
									</div>
									<div class="col-md-12">
										<hr>
									</div>
									<div>
										<div class="col-md-2">한줄요약</div>
										<div class="col-md-10">
											<input type="text" class="form-control" id="title"
												name="title">
										</div>
									</div>
									<div class="col-md-12">
										<hr class="bl">
									</div>
								</div>
								<div class="col-md-12">
								<div class="center-block" style='width: 250px'>
									<input type="submit" class="btn btn-primary" id="btnSubmit"
										value="등록"> <input type="button"
										class="btn btn-primary" value="취소" onclick="history.back(1)">
								</div></div>

							</form>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>