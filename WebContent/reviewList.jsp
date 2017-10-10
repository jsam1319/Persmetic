<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=utf-8">
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

<script src="js/jquery-1.11.0.min.js"></script>
<script src="js/respond.min.js"></script>
<script src="js/reviewList.js"></script>

<link rel="shortcut icon" href="favicon.png">
<title></title>
</head>
<body>
	<div id="all">
		<div id="content">
			<div class="container">
					<div class="row reviews">
						<!-- review -->
						<div>
						<h2>Review</h2>
						<hr>
                      <div id="listView"></div>
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
					
					<!-- paging -->
					<div class="pages">
						<nav aria-label="Page navigation">
							<ul class="pagination">
							<!--************2) 버튼 페이지 수 대로 출력 -페이지 갯수 구해서 for문 돌리기 -->
								<input type="button" class="page" value="1">
								<input type="button" class="page" value="2">
								<input type="button" class="page" value="3">
								<input type="button" class="page" value="4">
								<input type="button" class="page" value="5">
							</ul>
						</nav>
					</div>
					<!-- /.paging -->

			</div>
			<!-- /.container -->
		</div>
	</div>







</body>
</html>


