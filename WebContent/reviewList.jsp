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

<link rel="shortcut icon" href="favicon.png">
<title></title>
</head>
<script>
//리뷰작성 버튼 클릭
$(document).ready(function() {
	$("#reviewbtn").click(function() {
		location.href = "review_write.leaf?productCode=${product.productCode}&ctmNo=${cookie.customer.value}"
	})
	
	  $("#review-tab").click(function(){
		$("#review").load("review_list.leaf")
	})   
});
</script>
<body>
	<div id="all">
<!-- +++++++++++++++++++++ productCode, ctmName 가져오기 / 리스트띄우기 -->
		<div id="content">
			<div class="container">
					<div class="row reviews">
						<!-- review -->
						<div>
						<h2>Review</h2>
						<hr>
							<c:forEach items="${list}" var="i">
								  <c:if test="${product.productCode eq i.productCode}">  
								<div>
								<div class="col-md-1">
								 <%-- 	<p>${i.ctmId}</p>  --%>
								 	<p>reviewNo:${i.reviewNo }
									<p>grade:${i.reviewGrade}</p>
									<p>상품번호:
								</div>
								<div class="col-md-5">
									<p>productCode:${i.productCode}</p>
									 <p>productName:${i.productName}</p> 
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







</body>
</html>


