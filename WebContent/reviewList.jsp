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
		/* location.href = "review_write.leaf?productCode=${product.productCode}&ctmNo=${cookie.customer.value}" */
	})
	
	$.ajax({
		url: "review_list.leaf",
		dataType: "json",
		data : {
			"product_code" : 2
		},
		success: function(data){
			reviewList(data)
			console.log(data);
		},
		error : function(data, a, b){
			reviewList(data)
			console.log(a);
			console.log(b);
		}
	})
});

function reviewList(data){
	var list = "";
	console.log(data);
	console.log(typeof data);
	var json = data;
	console.log(json);
	for(var i in json.reviews) {
		list += "<div><div class='col-md-2'>";
		list += "<p>" + json.reviews[i].ctmId + "</p>";
		list += "<p>" + json.reviews[i].reviewGrade + "</p>";
		list += "</div>"
		list += "<div class='col-md-5'>"
		list += "<p>" + json.reviews[i].productCode + "</p>";
		list += "<p>" + json.reviews[i].productName + "</p>";
		list += "<p>" + json.reviews[i].reviewTitle + "</p>";
		list += "</div>"
		list += "<div class='col-md-2'>"
		list += "<p>" + json.reviews[i].reviewDate + "</p>";
		list += "</div></div>"
		list += "<div class='col-md-12'> <hr> </div>"
		
		var productCode = json.reviews[i].product_code
	}
	$("#listView").html(list);
	
}
</script>
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
											<li><a href="${pageBuilder.getQueryString(i)}&product_code=${productCode}">${i}</a></li>
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


